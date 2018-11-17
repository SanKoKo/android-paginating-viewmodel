package world.hello.san.stackoverflowproject;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import world.hello.san.stackoverflowproject.detail.Detail;
import world.hello.san.stackoverflowproject.model.Item;
import world.hello.san.stackoverflowproject.rest.ApiUtil;
import world.hello.san.stackoverflowproject.rest.SOFQuestion;
import world.hello.san.stackoverflowproject.soadaptor.RVAdaptor;
import world.hello.san.stackoverflowproject.viewmodel.ItemViewModel;
import world.hello.san.stackoverflowproject.util.QuestionDiff;

public class MainActivity extends AppCompatActivity implements RVAdaptor.CvItemClick {

    SOFQuestion sofQuestion;
    RecyclerView rv;
    RVAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=  findViewById(R.id.rv);
        sofQuestion = ApiUtil.getQuestion();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        adaptor = new RVAdaptor(new QuestionDiff());
        itemViewModel.getItemPagedList().observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(@Nullable PagedList<Item> items) {
                adaptor.submitList(items);
            }
        });
        rv.setAdapter(adaptor);
        adaptor.setOnRecyclerViewClickListener(this);

    }

    @Override
    public void onItemClick(Item item) {

        startActivity(new Intent(this,Detail.class).putExtra("item",item));

    }

}

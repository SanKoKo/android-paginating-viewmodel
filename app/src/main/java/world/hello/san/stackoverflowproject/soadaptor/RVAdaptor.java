package world.hello.san.stackoverflowproject.soadaptor;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import world.hello.san.stackoverflowproject.R;
import world.hello.san.stackoverflowproject.model.Item;

/**
 * Created by sanyatihan on 19-Nov-17.
 */

public class RVAdaptor extends PagedListAdapter<Item,RVAdaptor.PlaceHolder> {
 private Context context;
    private CvItemClick cvItemClick;

    public RVAdaptor(@NonNull DiffUtil.ItemCallback<Item> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new PlaceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull final PlaceHolder holder, int position) {

        final Item item = getItem(position);

        assert item != null;
        String pic = item.getOwner().getProfileImage();
        Glide.with(context).load(pic).into(holder.iv_pic);
        holder.tv_qus.setText(item.getTitle());
        holder.tv_name.setText(item.getOwner().getDisplayName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cvItemClick.onItemClick(item);
            }
        });

    }

    public void setOnRecyclerViewClickListener(CvItemClick cvItemClick){
        this.cvItemClick = cvItemClick;
    }

    class PlaceHolder extends RecyclerView.ViewHolder {

        ImageView iv_pic;
        TextView tv_qus;
        TextView tv_name;
        CardView cardView;
        PlaceHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            iv_pic = itemView.findViewById(R.id.iv_adaptor);
            tv_qus = itemView.findViewById(R.id.tv_question);
            tv_name = itemView.findViewById(R.id.tv_name);

        }
    }

    public interface  CvItemClick {
        void onItemClick(Item item);
    }
}

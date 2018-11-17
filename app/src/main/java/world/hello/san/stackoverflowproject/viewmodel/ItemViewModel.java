package world.hello.san.stackoverflowproject.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import world.hello.san.stackoverflowproject.model.Item;
import world.hello.san.stackoverflowproject.datasource.ItemDataSourceFactory;

public class ItemViewModel extends ViewModel {

    private LiveData<PagedList<Item>> itemPagedList;

    public ItemViewModel() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();

        //LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config.Builder pagedListConfigBuilder = new PagedList.Config.Builder();
        pagedListConfigBuilder.setEnablePlaceholders(false);
        pagedListConfigBuilder.setPageSize(30);


        LivePagedListBuilder<Integer,Item> livePagedListBuilder = new LivePagedListBuilder<Integer, Item>(itemDataSourceFactory, pagedListConfigBuilder.build());
        itemPagedList = livePagedListBuilder.build();
    }

    public LiveData<PagedList<Item>> getItemPagedList() {
        return itemPagedList;
    }


}
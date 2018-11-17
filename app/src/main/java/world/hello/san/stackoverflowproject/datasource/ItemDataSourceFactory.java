package world.hello.san.stackoverflowproject.datasource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import world.hello.san.stackoverflowproject.model.Item;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Item>> itemLiveDataSource = new MutableLiveData<>();
    @Override
    public DataSource create() {
        QuestionDataSource questionDataSource = new QuestionDataSource();
        itemLiveDataSource.postValue(questionDataSource);
        return questionDataSource;
    }

    /*public MutableLiveData<PageKeyedDataSource<Integer, Item>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }*/
}

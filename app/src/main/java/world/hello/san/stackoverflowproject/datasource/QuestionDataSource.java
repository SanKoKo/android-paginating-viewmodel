package world.hello.san.stackoverflowproject.datasource;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import world.hello.san.stackoverflowproject.model.Item;
import world.hello.san.stackoverflowproject.model.Question;
import world.hello.san.stackoverflowproject.rest.ApiUtil;

public class QuestionDataSource extends PageKeyedDataSource<Integer,Item> {
    private final int PAGE = 1;
    private final int PAGEMAX = 30;
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {
        ApiUtil.getQuestion().getQuestionByPaginating(PAGE,PAGEMAX).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if(response.body()!=null)
                callback.onResult(response.body().getItems(),null,PAGE+1);
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        ApiUtil.getQuestion().getQuestionByPaginating(PAGE,PAGEMAX).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                if (response.body() != null) {
                    callback.onResult(response.body().getItems(), adjacentKey);
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        ApiUtil.getQuestion().getQuestionByPaginating(PAGE,PAGEMAX).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if (response.body() != null) {
                    Integer key = response.body().getHasMore() ? params.key + 1 : null;
                    callback.onResult(response.body().getItems(), key);
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {

            }
        });
    }
}

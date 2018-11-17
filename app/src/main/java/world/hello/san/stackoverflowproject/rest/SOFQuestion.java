package world.hello.san.stackoverflowproject.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import world.hello.san.stackoverflowproject.model.Question;

/**
 * Created by sanyatihan on 19-Nov-17.
 */

public interface SOFQuestion {

    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    Call<Question> getAllQuestion();

    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow") /// tagged=android
    Call<Question> getAllQuestion(@Query("tagged") String tag);

    ///2.2/questions?page=1&pagesize=10&order=desc&sort=activity&site=stackoverflow
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    Call<Question> getQuestionByPaginating(@Query("page")int page,@Query("pagesize")int maxPagesize);
}

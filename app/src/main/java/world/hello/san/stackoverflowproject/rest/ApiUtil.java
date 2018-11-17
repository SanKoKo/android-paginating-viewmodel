package world.hello.san.stackoverflowproject.rest;

/**
 * Created by sanyatihan on 19-Nov-17.
 */

public class ApiUtil {
    private static final String BASE_URL = "https://api.stackexchange.com";

    public static SOFQuestion getQuestion() {
        return RetrofitClient.getBaseUrl(BASE_URL).create(SOFQuestion.class);
    }


}

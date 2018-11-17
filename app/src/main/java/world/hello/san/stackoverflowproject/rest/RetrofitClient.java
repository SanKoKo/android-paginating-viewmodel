package world.hello.san.stackoverflowproject.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sanyatihan on 19-Nov-17.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;
    
    public static Retrofit getBaseUrl(String url){
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
    
}

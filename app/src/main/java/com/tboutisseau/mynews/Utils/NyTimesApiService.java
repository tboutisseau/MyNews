package com.tboutisseau.mynews.Utils;

import com.tboutisseau.mynews.Models.TopStories;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NyTimesApiService {

    // Base URL and API key
    String apiKey = "e5NaNKgE4vEqdTX7LTANFstAdnGaJ2bN";
    String baseURL = "https://api.nytimes.com/svc/";

    // Makes the http request to fetch results on TopStories API
    @GET("topstories/v2/{section}.json")
    Observable<TopStories> getTopStoriesArticles(@Path("section") String subject, @Query("api-key") String api_key);


    // Configures Retrofit with the base url, the Gson converter and the RxJava call Adapter
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

}

package com.tboutisseau.mynews.Utils;

import com.tboutisseau.mynews.Models.MostPopular;
import com.tboutisseau.mynews.Models.TopStories;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NyTimesApiStreams {

    private static  NyTimesApiService mNyTimesApiService = NyTimesApiService.retrofit.create(NyTimesApiService.class);

    // Stream to fetch articles from the Top Stories API
    public static Observable<TopStories> streamTopStoriesArticles(String subject) {
        return mNyTimesApiService.getTopStoriesArticles(subject, NyTimesApiService.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    // Stream to fetch articles from the Most Popular API
    public static Observable<MostPopular> streamMostPopularArticles() {
        return mNyTimesApiService.getMostPopularArticles(NyTimesApiService.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }
}

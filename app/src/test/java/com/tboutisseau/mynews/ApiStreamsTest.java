package com.tboutisseau.mynews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tboutisseau.mynews.Models.TopStories;
import com.tboutisseau.mynews.Utils.NyTimesApiStreams;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public abstract class ApiStreamsTest {

    @BeforeClass
    public static void setUpRxSchedulers() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    public void streamTopStoriesArticle() {
        String path = "home";
        Observable<TopStories> articleTopObservable = NyTimesApiStreams.streamTopStoriesArticles(path);
        TestObserver<TopStories> articleTopTestObserver = new TestObserver<>();

        articleTopObservable.subscribeWith(articleTopTestObserver)
                .assertNoErrors()
                .assertNoTimeout()
                .awaitTerminalEvent();

        assertNotEquals(0, articleTopTestObserver.values().size());

        TopStories article = articleTopTestObserver.values().get(0);
        TopStories.Results result = article.getResults().get(0);

        assertEquals("OK", article.getStatus());
        assertEquals(path, article.getSection());

        assertNotNull(result.getTitle());
        assertNotNull(result.getUrl());
        assertNotNull(result.getSection());
        assertNotNull(result.getSubsection());
        assertNotNull(result.getPublished_date());
    }

}

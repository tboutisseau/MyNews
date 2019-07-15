package com.tboutisseau.mynews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tboutisseau.mynews.Models.MostPopular;
import com.tboutisseau.mynews.Models.TopStories;
import com.tboutisseau.mynews.Utils.NyTimesApiStreams;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ApiStreamsTest {


    // Set up
    @BeforeClass
    public static void setUpRxSchedulers() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Mock
    TopStories.Result mMockedResult;

    @Test
    public void streamTopStoriesArticlesTest() {
        String path = "home";
        Observable<TopStories> articleTopObservable = NyTimesApiStreams.streamTopStoriesArticles(path);
        TestObserver<TopStories> articleTopTestObserver = new TestObserver<>();

        articleTopObservable.subscribeWith(articleTopTestObserver)
                .assertNoErrors()
                .assertNoTimeout()
                .awaitTerminalEvent();

        assertNotEquals(0, articleTopTestObserver.values().size());

        TopStories article = articleTopTestObserver.values().get(0);
        TopStories.Result result = article.getResults().get(0);

        assertEquals("OK", article.getStatus());
        assertEquals(path, article.getSection());


        // Verify that the parameters of the response are not null
        assertNotNull(result.getTitle());
        assertNotNull(result.getUrl());
        assertNotNull(result.getSection());
        assertNotNull(result.getSubsection());
        assertNotNull(result.getPublished_date());
    }

    @Test
    public void streamMostPopularArticleTest() {

        Observable<MostPopular> articleMostPopularObservable = NyTimesApiStreams.streamMostPopularArticles();
        TestObserver<MostPopular> articleMostPopularObserver = new TestObserver<>();

        articleMostPopularObservable.subscribeWith(articleMostPopularObserver)
                .assertNoErrors()
                .assertNoTimeout()
                .awaitTerminalEvent();

        assertNotEquals(0, articleMostPopularObserver.values().size());

        MostPopular popularArticle = articleMostPopularObserver.values().get(0);
        MostPopular.Result result = popularArticle.getResults().get(0);

        assertEquals("OK", popularArticle.getStatus());

        assertNotNull(result.getTitle());
        assertNotNull(result.getByline());
        assertNotNull(result.getSection());
        assertNotNull(result.getUrl());
        assertNotNull(result.getPublishedDate());

    }


    @Test
    public void givenTitleMethodMocked_WhenGetTitleInvoked_ThenMockValueReturned() {

        Mockito.when(mMockedResult.getTitle()).thenReturn("This is not a headline");

        String title = mMockedResult.getTitle();

        Assert.assertEquals("This is not a headline", title);
        Mockito.verify(mMockedResult).getTitle();
    }

    @Test
    public void givenUrlMethodMocked_WhenGetUrlInvoked_ThenMockValueReturned() {

        Mockito.when(mMockedResult.getUrl()).thenReturn("https://www.lequipe.fr");

        String url = mMockedResult.getUrl();

        Assert.assertEquals("https://www.lequipe.fr", url);
        Mockito.verify(mMockedResult).getUrl();
    }

}

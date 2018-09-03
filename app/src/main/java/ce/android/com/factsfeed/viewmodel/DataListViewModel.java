package ce.android.com.factsfeed.viewmodel;

import android.databinding.BaseObservable;

import ce.android.com.factsfeed.model.FeedModel;

public class DataListViewModel extends BaseObservable {

    private FeedModel feed;

    public DataListViewModel(FeedModel feed) {
        this.feed = feed;
    }

    public FeedModel getFeed() {
        return feed;
    }

    public void setFeed(FeedModel feed) {
        this.feed = feed;
    }
}

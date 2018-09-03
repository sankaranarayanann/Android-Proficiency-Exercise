package ce.android.com.factsfeed.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import ce.android.com.factsfeed.Utils.CallUtils;
import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.model.FeedModel;
import ce.android.com.factsfeed.network.FactsService;
import ce.android.com.factsfeed.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
Repository to handle the network call to get facts feed
 */
public class FactsRepository {

    private static FactsRepository Instance = null;

    public static FactsRepository getInstance() {
        if (Instance == null)
            Instance = new FactsRepository();

        return Instance;
    }

    // Initiate the call to get facts
    public LiveData<FactsModel> getFacts() {
        final MutableLiveData<FactsModel> factsModelMutableLiveData = new MutableLiveData<>();
        FactsService service = RetrofitClient.getRetrofitInstance().create(FactsService.class);
        Call<FactsModel> call = service.getFeeds();
        CallUtils.enqueue(call, new Callback<FactsModel>() {
            @Override
            public void onResponse(@NonNull Call<FactsModel> call, @NonNull Response<FactsModel> response) {
                factsModelMutableLiveData.setValue(preProcessData(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<FactsModel> call, Throwable t) {
                factsModelMutableLiveData.setValue(null);
            }
        });

        return factsModelMutableLiveData;
    }

    // process the data from the response to skip invalid data
    private FactsModel preProcessData(FactsModel facts) {

        if (facts != null) {
            for (int i = 0; i < facts.getRows().size(); i++) {
                FeedModel feed = facts.getRows().get(i);
                if (feed.getTitle() == null && feed.getDescription() == null && feed.getImageHref() == null)
                    facts.getRows().remove(feed);
            }
        }

        return facts;
    }
}

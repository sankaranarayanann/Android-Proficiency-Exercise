package ce.android.com.factsfeed.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.network.FactsService;
import ce.android.com.factsfeed.network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactsRepository {

    private static FactsRepository Instance = null;

    public  static FactsRepository getInstance() {
        if (Instance == null)
            Instance = new FactsRepository();

        return Instance;
    }

    public LiveData<FactsModel> getFacts(){
        final MutableLiveData<FactsModel> factsModelMutableLiveData = new MutableLiveData<>();
        FactsService service = RetrofitClientInstance.getRetrofitInstance().create(FactsService.class);
        Call<FactsModel> call = service.getFeeds();
        call.enqueue(new Callback<FactsModel>() {
            @Override
            public void onResponse(@NonNull Call<FactsModel> call, @NonNull Response<FactsModel> response) {
                factsModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<FactsModel> call, Throwable t) {
                factsModelMutableLiveData.setValue(null);
            }
        });

        return factsModelMutableLiveData;
    }
}

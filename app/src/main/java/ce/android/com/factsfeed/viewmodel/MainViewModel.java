package ce.android.com.factsfeed.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.model.FeedModel;
import ce.android.com.factsfeed.repository.FactsRepository;

public class MainViewModel extends AndroidViewModel {

    private LiveData<FactsModel> factsModelLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<FactsModel> GetFacts(){

        factsModelLiveData = FactsRepository.getInstance().getFacts();

//        FactsModel facts = new FactsModel();
//        facts.setTitle("About Canada");
//        ArrayList<FeedModel> rows = new ArrayList<>();
//        rows.add(new FeedModel("Title1", "Description1","http://fyimusic.ca/wp-content/uploads/2008/06/hockey-night-in-canada.thumbnail.jpg"));
//        rows.add(new FeedModel("Title2", "Description2","http://fyimusic.ca/wp-content/uploads/2008/06/hockey-night-in-canada.thumbnail.jpg"));
//        rows.add(new FeedModel("Title3", "Description3","http://fyimusic.ca/wp-content/uploads/2008/06/hockey-night-in-canada.thumbnail.jpg"));
//
//        facts.setRows(rows);
//
//        factsModelMutableLiveData.setValue(facts);

        return factsModelLiveData;
    }


}

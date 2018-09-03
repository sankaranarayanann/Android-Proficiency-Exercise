package ce.android.com.factsfeed.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.repository.FactsRepository;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<FactsModel> getFacts(){
        return FactsRepository.getInstance().getFacts();
    }


}

package ce.android.com.factsfeed.test;

import android.arch.lifecycle.LiveData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;

import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.runner.FactsFeedRobolectricTestRunner;
import ce.android.com.factsfeed.viewmodel.MainViewModel;

@RunWith(FactsFeedRobolectricTestRunner.class)
public class MainViewModelTest {

    MainViewModel mainVM;

    @Before
    public void setup_MainViewModel(){
        mainVM = new MainViewModel(RuntimeEnvironment.application);
    }

    @After
    public void dispose_MainViewModel(){
        mainVM = null;
    }

    @Test
    public void viewModel_Creation_Test(){
        Assert.assertNotNull("Main viewModel is null",mainVM);
    }

    @Test
    public void getFacts_Method_Test(){
        LiveData<FactsModel> factsModelLiveData = mainVM.getFacts();
        Assert.assertNotNull("Facts model live data is null", factsModelLiveData);
    }
}

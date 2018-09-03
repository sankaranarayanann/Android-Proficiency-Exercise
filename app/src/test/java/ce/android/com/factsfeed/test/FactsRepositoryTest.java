package ce.android.com.factsfeed.test;

import android.arch.lifecycle.LiveData;
import android.view.View;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.model.FeedModel;
import ce.android.com.factsfeed.repository.FactsRepository;
import ce.android.com.factsfeed.runner.FactsFeedRobolectricTestRunner;
import ce.android.com.factsfeed.shadow.ShadowCallUtils;

import static org.fest.reflect.core.Reflection.method;


@RunWith(FactsFeedRobolectricTestRunner.class)
@Config(shadows = {ShadowCallUtils.class})
public class FactsRepositoryTest {

    FactsRepository factsRepo;

    @Before
    public void setup_FactsRepository(){
        factsRepo = FactsRepository.getInstance();
    }

    @After
    public void dispose_FactsRepository(){
        factsRepo = null;
    }

    @Test
    public void repo_Creation_Test(){
        Assert.assertNotNull("Facts repo instance is null",factsRepo);
    }

    @Test
    public void repo_Singleton_Test(){
        FactsRepository anotherInstance = FactsRepository.getInstance();
        Assert.assertEquals("Singleton instance are different", factsRepo, anotherInstance);
    }

    @Test
    public void repo_getFacts_Method_Test(){
        LiveData<FactsModel> factsModelLiveData = factsRepo.getFacts();
        Assert.assertNotNull("Facts model live data is null", factsModelLiveData);
    }

    @Test
    public void repo_preProcessData_Method_Test(){
        FactsModel factsModel = new FactsModel();
        ArrayList<FeedModel> data = new ArrayList<>();
        data.add(new FeedModel("Feed Title 1", "Feed Description 1", ""));
        data.add(new FeedModel("Feed Title 2", "Feed Description 2", ""));
        data.add(new FeedModel("", "", ""));
        factsModel.setRows(data);
        factsModel.setTitle("Facts Feed");

        method("preProcessData").withParameterTypes(FactsModel.class).in(factsRepo).invoke(factsModel);

        Assert.assertNotEquals("Empty feed not removed",2, factsModel.getRows().size());
    }
}
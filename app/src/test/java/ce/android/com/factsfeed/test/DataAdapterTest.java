package ce.android.com.factsfeed.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import ce.android.com.factsfeed.adapter.DataAdapter;
import ce.android.com.factsfeed.model.FeedModel;
import ce.android.com.factsfeed.runner.FactsFeedRobolectricTestRunner;

@RunWith(FactsFeedRobolectricTestRunner.class)
public class DataAdapterTest {

    DataAdapter adapter;

    @Before
    public void before(){
        adapter = new DataAdapter();
    }

    @Test
    public void adapter_Creation_Test(){
        Assert.assertNotNull("Data Adapter instance is null", adapter);
    }

    @Test
    public void adapter_UpdateData_Test(){

        Assert.assertEquals("Adapter data is already initialized",0, adapter.getItemCount());

        ArrayList<FeedModel> data = new ArrayList<>();
        data.add(new FeedModel("Feed Title 1", "Feed Description 1", ""));
        data.add(new FeedModel("Feed Title 2", "Feed Description 2", ""));
        data.add(new FeedModel("Feed Title 3", "Feed Description 3", ""));
        adapter.updateData(data);

        Assert.assertEquals("Update Data method fails to update the given data",3, adapter.getItemCount());
    }

}

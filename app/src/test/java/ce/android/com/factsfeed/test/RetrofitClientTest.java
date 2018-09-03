package ce.android.com.factsfeed.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ce.android.com.factsfeed.network.RetrofitClient;
import ce.android.com.factsfeed.runner.FactsFeedRobolectricTestRunner;

@RunWith(FactsFeedRobolectricTestRunner.class)
public class RetrofitClientTest {

    @Test
    public void getRetrofit_Instance_Test(){
        Assert.assertNotNull("Retrofit client instance is null", RetrofitClient.getRetrofitInstance());
    }

}

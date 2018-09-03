package ce.android.com.factsfeed.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import ce.android.com.factsfeed.runner.FactsFeedRobolectricTestRunner;
import ce.android.com.factsfeed.shadow.ShadowCallUtils;
import ce.android.com.factsfeed.shadow.ShadowUtils;
import ce.android.com.factsfeed.view.fragment.MainFragment;

import static org.fest.reflect.core.Reflection.field;
import static org.fest.reflect.core.Reflection.method;

@RunWith(FactsFeedRobolectricTestRunner.class)
@Config(shadows = {ShadowCallUtils.class, ShadowUtils.class})
public class MainFragmentTest {

    MainFragment mainFragment;

    @Before
    public void before(){
        mainFragment = new MainFragment();
    }

    @Test
    public void fragment_RecyclerView_Init_Test(){
        method("initRecyclerView").withParameterTypes(View.class).in(mainFragment).invoke(new View(RuntimeEnvironment.application.getApplicationContext()));
        RecyclerView recyclerView = field("swipeRefreshLayout").ofType(RecyclerView.class).
                in(mainFragment).get();

        Assert.assertNotNull("RecyclerView is not initialized", recyclerView);
    }

}

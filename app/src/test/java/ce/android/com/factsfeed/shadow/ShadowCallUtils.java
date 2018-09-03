package ce.android.com.factsfeed.shadow;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import ce.android.com.factsfeed.Utils.CallUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Implements(CallUtils.class)
public class ShadowCallUtils {

    public static boolean isSuccess;

    @Implementation
    public static void enqueue(Call call, Callback callback) {

        if(isSuccess)
            callback.onResponse(call, Response.success(true));
        else
            callback.onFailure(call, new Throwable("error"));
    }
}

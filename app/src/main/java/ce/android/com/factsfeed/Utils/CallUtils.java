package ce.android.com.factsfeed.Utils;

import retrofit2.Call;
import retrofit2.Callback;

public class CallUtils {

    public static void enqueue(Call call, Callback callback) {
        call.enqueue(callback);
    }
}

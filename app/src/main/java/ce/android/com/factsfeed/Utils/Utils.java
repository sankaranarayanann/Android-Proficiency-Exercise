package ce.android.com.factsfeed.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";
    public static final String GET_FEEDS = "facts.js";

    public static boolean isInternetConnected(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }
}


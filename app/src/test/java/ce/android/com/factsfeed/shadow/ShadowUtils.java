package ce.android.com.factsfeed.shadow;

import android.content.Context;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import ce.android.com.factsfeed.Utils.Utils;

@Implements(Utils.class)
public class ShadowUtils {

    @Implementation
    public static boolean isInternetConnected(Context context){
        return true;
    }
}

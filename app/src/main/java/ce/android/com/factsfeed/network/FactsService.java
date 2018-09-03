package ce.android.com.factsfeed.network;

import ce.android.com.factsfeed.Utils.Utils;
import ce.android.com.factsfeed.model.FactsModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FactsService {

    @GET(Utils.GET_FEEDS)
    Call<FactsModel> getFeeds();
}

package ce.android.com.factsfeed.network;

import ce.android.com.factsfeed.Utils.Utils;
import ce.android.com.factsfeed.model.FactsModel;
import retrofit2.Call;
import retrofit2.http.GET;

/*
Service interface for Facts entities
 */
public interface FactsService {

    // Retrieves the facts feed
    @GET(Utils.GET_FEEDS)
    Call<FactsModel> getFeeds();
}

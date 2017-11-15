import com.sonika.nepstra.pojo.User;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Prakriti on 11/14/2017.
 */

public interface Interface {
    String BASE_URL = "https://www.reddit.com/";

    @POST(".json")
    Call<User> getUser();


}


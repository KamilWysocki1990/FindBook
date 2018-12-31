package findbookproject.k.findbook.network;

import java.util.List;

import findbookproject.k.findbook.data.Anserws;
import findbookproject.k.findbook.data.Items;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL = "https://www.googleapis.com/books/v1/";

    @GET
    Flowable<Anserws>getBook(@Url String url);

}

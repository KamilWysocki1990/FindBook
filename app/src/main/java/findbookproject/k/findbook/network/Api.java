package findbookproject.k.findbook.network;

import findbookproject.k.findbook.data.Book;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://www.googleapis.com/books/v1/";

    @GET
    Flowable<Book>getBook(String url);


}

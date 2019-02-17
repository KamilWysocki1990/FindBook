package findbookproject.k.findbook.activitys.findActivity;

import javax.inject.Inject;

import findbookproject.k.findbook.network.Api;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FindActivityModel {

    @Inject
    Api api;

    CompositeDisposable compositeDisposable = new CompositeDisposable();


    public void getDataFromApi() {
/*
        searchEditText = "volumes?q=" + searchEditText;
        // List<Items> items = new ArrayList<>();
        compositeDisposable.add(
                api.getBook(searchEditText)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                books -> {
                                    view.setRecycler(books.items);
                                }, throwable -> {
                                    //On Error
                                }, () -> {
                                    view.setRecyclerVisible();
                                }
                        )
        );

    }
*/
}

}

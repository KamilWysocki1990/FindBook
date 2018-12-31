package findbookproject.k.findbook.findActivity;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

import java.util.List;

import findbookproject.k.findbook.data.Items;
import findbookproject.k.findbook.network.Api;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FindActivityPresenter implements FindActivityContract.Presenter, LifecycleObserver {

    private List<Items> items;
    private Api api;
    private FindActivityContract.View view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public FindActivityPresenter(FindActivityContract.View view, Api api) {
        this.view = view;
        this.api = api;

        ((LifecycleOwner) view).getLifecycle().addObserver(this);

    }


    @Override
    public void searchForTextOrBook(String searchEditText) {


        if (searchEditText.isEmpty()) {
            view.showTextAfterEditTextSearchIsEmpty();
        } else {
            searchEditText = "volumes?q=" + searchEditText;

            compositeDisposable.add(
                    api.getBook(searchEditText)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    books -> {
                                        view.showHowManyAnserwsWasFound(String.valueOf(books.totalItems));
                                    }
                            )
            );

        }


    }
}

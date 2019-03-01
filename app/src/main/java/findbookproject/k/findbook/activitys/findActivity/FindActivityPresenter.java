package findbookproject.k.findbook.activitys.findActivity;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import findbookproject.k.findbook.activitys.findActivity.findActivityModel.FindActivityModel;
import findbookproject.k.findbook.activitys.findActivity.findActivityModel.FindActivityModelHelper;
import findbookproject.k.findbook.data.Items;
import findbookproject.k.findbook.network.Api;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FindActivityPresenter implements FindActivityContract.Presenter, LifecycleObserver {

    private List<Items> items = new ArrayList<>();
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
         getDataFromModel(searchEditText);
        }


    }

    private void getDataFromModel(String request) {

        request = "volumes?q=" + request;
        compositeDisposable.add(
                api.getBook(request)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                books -> {
                                        view.setRecycler(books.items);
                                }, Throwable::printStackTrace
                                , () -> {

                                    view.setRecyclerVisible();
                                }
                        )
        );


    }

}

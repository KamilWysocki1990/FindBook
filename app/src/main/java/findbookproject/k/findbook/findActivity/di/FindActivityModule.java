package findbookproject.k.findbook.findActivity.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import findbookproject.k.findbook.findActivity.FindActivityContract;
import findbookproject.k.findbook.findActivity.FindActivityPresenter;
import findbookproject.k.findbook.network.Api;

@Module
public class FindActivityModule {

    FindActivityContract.View view;

    public FindActivityModule(FindActivityContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    FindActivityContract.Presenter provideFindActivityPresenter(Api api) {
        return new FindActivityPresenter(view, api) {
        };
    }
}
package findbookproject.k.findbook.activitys.findActivity.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import findbookproject.k.findbook.activitys.findActivity.FindActivityContract;
import findbookproject.k.findbook.activitys.findActivity.findActivityModel.FindActivityModel;
import findbookproject.k.findbook.activitys.findActivity.FindActivityPresenter;
import findbookproject.k.findbook.activitys.findActivity.findActivityModel.FindActivityModelHelper;
import findbookproject.k.findbook.data.dao.BookDaoInterface;
import findbookproject.k.findbook.network.Api;

@Module
public class FindActivityModule {

    FindActivityContract.View view;

    public FindActivityModule(FindActivityContract.View view) {

        this.view = view;

    }

    @Provides
    @Singleton
    FindActivityContract.Presenter provideFindActivityPresenter(Api api, BookDaoInterface bookDaoInterface) {
        return new FindActivityPresenter(view,api, bookDaoInterface) {
        };
    }

}

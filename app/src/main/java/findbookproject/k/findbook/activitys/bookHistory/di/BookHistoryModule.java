package findbookproject.k.findbook.activitys.bookHistory.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import findbookproject.k.findbook.activitys.bookHistory.BookHistoryContract;
import findbookproject.k.findbook.activitys.bookHistory.BookHistoryPresenter;
import findbookproject.k.findbook.activitys.chosenBookActivity.ChosenBookContract;
import findbookproject.k.findbook.activitys.chosenBookActivity.ChosenBookPresenter;
import findbookproject.k.findbook.data.dao.BookDaoInterface;

@Module
public class BookHistoryModule {

    BookHistoryContract.View view;

    public BookHistoryModule(BookHistoryContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
   BookHistoryContract.Presenter provideBookHistoryPresenter(BookDaoInterface bookDaoInterface){
        return new BookHistoryPresenter(view,bookDaoInterface);
    }

}

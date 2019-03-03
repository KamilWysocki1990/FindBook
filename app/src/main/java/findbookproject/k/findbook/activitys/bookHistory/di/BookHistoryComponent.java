package findbookproject.k.findbook.activitys.bookHistory.di;

import javax.inject.Singleton;

import dagger.Subcomponent;
import findbookproject.k.findbook.activitys.bookHistory.BookHistoryActivity;



@Singleton
@Subcomponent(modules = {BookHistoryModule.class})
public interface BookHistoryComponent {


        void inject(BookHistoryActivity BookHistoryActivity);

}

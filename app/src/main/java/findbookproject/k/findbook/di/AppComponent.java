package findbookproject.k.findbook.di;

import dagger.Component;
import findbookproject.k.findbook.ApplicationScope;
import findbookproject.k.findbook.activitys.bookHistory.di.BookHistoryComponent;
import findbookproject.k.findbook.activitys.bookHistory.di.BookHistoryModule;
import findbookproject.k.findbook.activitys.chosenBookActivity.di.ChosenBookComponent;
import findbookproject.k.findbook.activitys.chosenBookActivity.di.ChosenBookModule;
import findbookproject.k.findbook.activitys.findActivity.di.FindActivityComponent;
import findbookproject.k.findbook.activitys.findActivity.di.FindActivityModule;

@ApplicationScope
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    FindActivityComponent plus (FindActivityModule findActivityModule);
    ChosenBookComponent plus (ChosenBookModule chosenBookModule);
    BookHistoryComponent plus (BookHistoryModule bookHistoryModule);



}

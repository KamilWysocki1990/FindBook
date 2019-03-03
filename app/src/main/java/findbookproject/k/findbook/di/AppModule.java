package findbookproject.k.findbook.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import findbookproject.k.findbook.ApplicationScope;
import findbookproject.k.findbook.data.dao.BookDao;
import findbookproject.k.findbook.data.dao.BookDaoInterface;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    Context provideContext() {
        return context;
    }

    @Provides
    @ApplicationScope
    BookDaoInterface provideBookDaoInterface(BookDao bookDao) {
        return bookDao;
    }


}

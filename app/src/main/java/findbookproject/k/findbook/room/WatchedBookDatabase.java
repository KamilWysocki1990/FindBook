package findbookproject.k.findbook.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import findbookproject.k.findbook.data.watchedBook.WatchedBook;
import findbookproject.k.findbook.data.dao.BookDao;

@Database(entities = {WatchedBook.class}, version = 1)

@TypeConverters({Converters.class})
public abstract class WatchedBookDatabase extends RoomDatabase {
    public static final String NAME = "BookDatabase";
    public abstract BookDao bookDao();

}

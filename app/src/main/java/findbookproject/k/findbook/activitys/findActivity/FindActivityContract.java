package findbookproject.k.findbook.activitys.findActivity;

import java.util.List;

import findbookproject.k.findbook.data.watchedBook.WatchedBook;
import findbookproject.k.findbook.data.bookInfo.Items;

public interface FindActivityContract {

    interface View{
         void showTextAfterEditTextSearchIsEmpty();
        void setRecycler(List<Items> items);
        void setRecyclerVisible();
    }

    interface Presenter{
         void searchForTextOrBook(String searchEditText);
        void saveBookToDatabase(WatchedBook watchedBook);
    }
    interface BookListener{

        void passBookToDatabase(WatchedBook watchedBook);
    }
}

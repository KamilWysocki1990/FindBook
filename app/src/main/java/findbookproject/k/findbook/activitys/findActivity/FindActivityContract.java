package findbookproject.k.findbook.activitys.findActivity;

import java.util.List;

import findbookproject.k.findbook.data.Items;

public interface FindActivityContract {

    interface View{
         void showTextAfterEditTextSearchIsEmpty();
        void setRecycler(List<Items> items);
        void setRecyclerVisible();
    }

    interface Presenter{
         void searchForTextOrBook(String searchEditText);
    }
}

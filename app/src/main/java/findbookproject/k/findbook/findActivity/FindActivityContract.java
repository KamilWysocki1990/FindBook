package findbookproject.k.findbook.findActivity;

import java.util.List;

import findbookproject.k.findbook.data.Items;

public interface FindActivityContract {

    interface View{
         void showTextAfterEditTextSearchIsEmpty();
         void showHowManyAnswersWasFound(String numberOfAnserws);
        void setRecycler(List<Items> items);
    }

    interface Presenter{
         void searchForTextOrBook(String searchEditText);
    }
}

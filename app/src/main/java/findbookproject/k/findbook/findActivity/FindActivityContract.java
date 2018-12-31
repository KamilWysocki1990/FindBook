package findbookproject.k.findbook.findActivity;

import findbookproject.k.findbook.data.ResponseBooks;

public interface FindActivityContract {

    interface View{
         void showTextAfterEditTextSearchIsEmpty();
         void showHowManyAnserwsWasFound(String numberOfAnserws);
    }

    interface Presenter{
         void searchForTextOrBook(String searchEditText);
    }
}

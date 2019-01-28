package findbookproject.k.findbook.activitys.chosenBookActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

public interface ChosenBookContract {

    interface View{


        void displayTitle(String textForTitle);

        void displayLanguage(String textForBookLanguage);

        void displayInfoLink(String textForInfoLink);

        void displayWebReaderLink(String textForWebReaderLink);

        void displayBookMaturity(String textForBookMaturity);

        void displayDownloadLink(String textForDownloadLink);

        void displayBuyLink(String textForBookBuyLink);

        void displayBookDescription(String textForDescription);

        void displayImageBook(Bitmap bitmapImage);
    }
     interface Presenter{

         void getDataFromBundle(Bundle bundle);

    }

}

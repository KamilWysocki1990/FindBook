package findbookproject.k.findbook.activitys.chosenBookActivity;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class ChosenBookPresenter implements ChosenBookContract.Presenter, LifecycleObserver {

    private ChosenBookContract.View view;
    private String noInformationProvidedText="Information not provided";

    public ChosenBookPresenter(ChosenBookContract.View view) {
        this.view = view;
        ((LifecycleOwner) view).getLifecycle().addObserver(this);
    }


    @Override
    public void getDataFromBundle(Bundle bookDataToCheck) {

       String [] keysToData = bookDataToCheck.getStringArray("KeyArray");

        passTitleToView(bookDataToCheck, keysToData[0]);
        passLanguageToView(bookDataToCheck, keysToData[1]);
        passInfoLinkToView(bookDataToCheck, keysToData[2]);
        passWebReaderLinkToView(bookDataToCheck, keysToData[3]);
        passBookMaturityToView(bookDataToCheck, keysToData[4]);
        passDownloadLinkToView(bookDataToCheck, keysToData[5]);
        passBuyLinkToView(bookDataToCheck, keysToData[6]);
        passBookDescriptionToView(bookDataToCheck, keysToData[7]);
        passBookImageToView(bookDataToCheck);



       }

       private void passBookImageToView(Bundle bookDataToCheck){
           bookDataToCheck.getByteArray("BookImageArray");
           byte[] image = bookDataToCheck.getByteArray("BookImageArray");
           Bitmap bitmapImage = BitmapFactory.decodeByteArray(image,0,image.length);
           view.displayImageBook(bitmapImage);
       }

    private void passBookDescriptionToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForDescription = "";
        if(keysToDatum !=null){
            textForDescription =  bookDataToCheck.getString("BookDescription");
        } else {
            textForDescription = noInformationProvidedText;
        }
        view.displayBookDescription(textForDescription);
    }

    private void passBuyLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForBookBuyLink = "";
        if(keysToDatum !=null){
            textForBookBuyLink =  bookDataToCheck.getString("BookBuyLink");
        } else {
            textForBookBuyLink = noInformationProvidedText;
        }
        view.displayBuyLink(textForBookBuyLink);
    }

    private void passDownloadLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForDownloadLink = "";
        if(keysToDatum !=null){
            textForDownloadLink =  bookDataToCheck.getString("BookDownload");
        } else {
            textForDownloadLink = noInformationProvidedText;
        }
        view.displayDownloadLink(textForDownloadLink);
    }

    private void passBookMaturityToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForBookMaturity = "";
        if(keysToDatum !=null){
            textForBookMaturity =  bookDataToCheck.getString("BookMaturity");
        } else {
            textForBookMaturity = noInformationProvidedText;
        }
        view.displayBookMaturity(textForBookMaturity);
    }

    private void passWebReaderLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForWebReaderLink = "";
        if(keysToDatum !=null){
            textForWebReaderLink =  bookDataToCheck.getString("BookWebReaderLink");
        } else {
            textForWebReaderLink = noInformationProvidedText;
        }
        view.displayWebReaderLink(textForWebReaderLink);
    }

    private void passInfoLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForInfoLink = "";
        if(keysToDatum !=null){
            textForInfoLink =  bookDataToCheck.getString("BookInfolink");
        } else {
            textForInfoLink = noInformationProvidedText;
        }
        view.displayInfoLink(textForInfoLink);
    }

    private void passLanguageToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForBookLanguage = "";
        if(keysToDatum !=null){
            textForBookLanguage =  bookDataToCheck.getString("BookLanguage");
        } else {
            textForBookLanguage = noInformationProvidedText;
        }
        view.displayLanguage(textForBookLanguage);
    }

    private void passTitleToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForTitle = "";
        if(keysToDatum !=null){
          textForTitle =  bookDataToCheck.getString("BookTitle");
        } else {
            textForTitle = noInformationProvidedText;
        }
        view.displayTitle(textForTitle);
    }

}

package findbookproject.k.findbook.activitys.chosenBookActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URL;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import findbookproject.k.findbook.FindBookApplication;
import findbookproject.k.findbook.R;
import findbookproject.k.findbook.activitys.chosenBookActivity.di.ChosenBookModule;

public class ChosenBookActivity extends AppCompatActivity implements ChosenBookContract.View {

    @BindView(R.id.image_chosen_book)
    ImageView imageViewChosenBook;

    @BindView(R.id.book_name)
    TextView bookName;

    @BindView(R.id.book_description)
    TextView bookDescription;

    @BindView(R.id.book_language)
    TextView bookLanguage;

    @BindView(R.id.book_maturity)
    TextView bookMaturity;

    @Inject
    ChosenBookContract.Presenter presenter;


   private String urlInfoLink = "";
   private String urlWebReaderLink = "";
   private String urlDownloadLink = "";

    private boolean checkingIfDataAreAvailable(Bundle bundleToCheck, String keyToGetData) {
        if (null != bundleToCheck.getString(keyToGetData)) {
            return true;
        } else
            return false;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosen_book);
        ButterKnife.bind(this);
        ((FindBookApplication) getApplication())
                .getAppComponent()
                .plus(new ChosenBookModule(this))
                .inject(this);


        Bundle bookData = getIntent().getExtras();
        presenter.getDataFromBundle(bookData);


    }


    @OnClick(R.id.button_book_infoLink)
    public void goToInfolink() {

        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(urlInfoLink));
        startActivity(browse);
    }

    @OnClick(R.id.button_web_reader_link)
    public void goToWebReaderlink() {

        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWebReaderLink));
        startActivity(browse);
    }

    @OnClick(R.id.button_book_download)
    public void goToDownloadLink() {

        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDownloadLink));
        startActivity(browse);
    }


    @Override
    public void displayTitle(String textForTitle) {
        bookName.setText(textForTitle);
    }

    @Override
    public void displayLanguage(String textForBookLanguage) {
        bookLanguage.setText(textForBookLanguage);
    }

    @Override
    public void displayInfoLink(String textForInfoLink) {
        urlInfoLink = textForInfoLink;
    }

    @Override
    public void displayWebReaderLink(String textForWebReaderLink) {
        urlWebReaderLink = textForWebReaderLink;
    }

    @Override
    public void displayBookMaturity(String textForBookMaturity) {
        bookMaturity.setText(textForBookMaturity);
    }

    @Override
    public void displayDownloadLink(String textForDownloadLink) {
        urlDownloadLink = textForDownloadLink;
    }

    @Override
    public void displayBuyLink(String textForBookBuyLink) {

    }

    @Override
    public void displayBookDescription(String textForDescription) {
        bookDescription.setMovementMethod(new ScrollingMovementMethod());
        bookDescription.setText(textForDescription);
    }

    @Override
    public void displayImageBook(Bitmap bitmapImage) {
        imageViewChosenBook.setImageBitmap(bitmapImage);
    }

}

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import findbookproject.k.findbook.R;

public class ChosenBookActivity extends AppCompatActivity implements ChosenBookContract.View{

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

    String urlInfoLink = "" ;
    String urlWebReaderLink = "" ;
    String urlDownloadLink = "";

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


        Bundle bookData = getIntent().getExtras();

        if (checkingIfDataAreAvailable(bookData, "BookTitle")) {
            bookName.setText(bookData.getString("BookTitle"));
        } else {
            bookName.setText(R.string.no_information);
        }

        if (checkingIfDataAreAvailable(bookData, "BookDescription")) {
            bookDescription.setText(bookData.getString("BookDescription"));
            bookDescription.setMovementMethod(new ScrollingMovementMethod());
        } else {
            bookDescription.setText(R.string.no_information);
        }

        if (checkingIfDataAreAvailable(bookData, "BookInfolink")) {
            urlInfoLink =String.valueOf(bookData.get("BookInfolink"));
        }


        if (checkingIfDataAreAvailable(bookData, "BookMaturity")) {
            bookMaturity.setText(bookData.getString("BookMaturity"));
        } else {
            bookMaturity.setText(R.string.no_information);
        }

        if (checkingIfDataAreAvailable(bookData, "BookLanguage")) {
            bookLanguage.setText(bookData.getString("BookLanguage"));
        } else {
            bookLanguage.setText(R.string.no_information);
        }




        if (checkingIfDataAreAvailable(bookData, "BookWebReaderLink")) {
            urlWebReaderLink =String.valueOf(bookData.get("BookWebReaderLink"));
        }

        if (checkingIfDataAreAvailable(bookData, "BookDownload")) {
            urlDownloadLink =String.valueOf(bookData.get("BookDownload"));
        }

            bookData.getByteArray("BookImageArray");
        byte[] image = bookData.getByteArray("BookImageArray");
            Bitmap bitmapImage = BitmapFactory.decodeByteArray(image,0,image.length);
            imageViewChosenBook.setImageBitmap(bitmapImage);

    }

    private void setDataOnParticularView(){

    }

    @OnClick(R.id.button_book_infoLink)
    public void goToInfolink() {

        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( urlInfoLink ) );
        startActivity( browse );
    }

    @OnClick(R.id.button_web_reader_link)
    public void goToWebReaderlink() {

        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( urlWebReaderLink ) );
        startActivity( browse );
    }

    @OnClick(R.id.button_book_download)
    public void goToDownloadLink() {

        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( urlDownloadLink ) );
        startActivity( browse );
    }


}

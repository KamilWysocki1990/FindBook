package findbookproject.k.findbook.findActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import findbookproject.k.findbook.R;

public class ChosenBookActivity extends AppCompatActivity {

    public static final String BOOK_NAME_KEY = "Book Name key";
    public static final String BOOK_LANGUAGE_KEY = "Book Name key";
    public static final String BOOK_INFOLINK_KEY = "Book Name key";
    public static final String BOOK_MATURITY_KEY = "Book Name key";
    public static final String BOOK_NAME_KEY = "Book Name key";




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosen_book);
        ButterKnife.bind(this);




    }
}

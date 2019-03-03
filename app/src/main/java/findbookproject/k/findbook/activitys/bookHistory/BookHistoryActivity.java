package findbookproject.k.findbook.activitys.bookHistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import findbookproject.k.findbook.R;
import findbookproject.k.findbook.data.dao.BookDaoInterface;

public class BookHistoryActivity extends AppCompatActivity implements BookHistoryContract.View {

    @Inject
    BookHistoryContract.Presenter presenter;
    HistoryBookAdapter historyBookAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_history);
        ButterKnife.bind(this);



    }

}

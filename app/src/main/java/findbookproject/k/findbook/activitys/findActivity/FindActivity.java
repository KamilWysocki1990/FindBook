package findbookproject.k.findbook.activitys.findActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import findbookproject.k.findbook.FindBookApplication;
import findbookproject.k.findbook.R;
import findbookproject.k.findbook.data.Items;
import findbookproject.k.findbook.activitys.findActivity.di.FindActivityModule;

public class FindActivity extends AppCompatActivity implements FindActivityContract.View {

    @Inject
    FindActivityContract.Presenter presenter;

    @BindView(R.id.book_recycler)
    RecyclerView bookRecycler;

    @BindView(R.id.searchEditText)
    EditText searchEditText;

    @BindView(R.id.textForShow)
    TextView textView;

    @BindView (R.id.search_button)
    Button searchButton;

    private FindAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findbook);
        ButterKnife.bind(this);
        ((FindBookApplication) getApplication())
                .getAppComponent()
                .plus(new FindActivityModule(this))
                .inject(this);

        adapter = new FindAdapter();
        bookRecycler.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        bookRecycler.addItemDecoration(itemDecoration);
        bookRecycler.setHasFixedSize(true);
        bookRecycler.setAdapter(adapter);



    }

    @OnClick(R.id.search_button)
    public void onSearchClick() {
       final Animation animButton = AnimationUtils.loadAnimation(this,R.anim.bounce);
        searchButton.startAnimation(animButton);
        presenter.searchForTextOrBook(searchEditText.getText().toString());

    }


    @Override
    public void showTextAfterEditTextSearchIsEmpty() {
        Toast.makeText(this, "Sorry:(, couldn't found what to search :(", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showHowManyAnswersWasFound(String numberOfAnswers) {
        textView.setText(numberOfAnswers);
    }

    @Override
    public void setRecycler(List<Items> items) {

        adapter.updateBooks(items);
    }
}

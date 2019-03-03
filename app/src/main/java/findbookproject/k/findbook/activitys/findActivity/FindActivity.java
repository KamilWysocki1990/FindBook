package findbookproject.k.findbook.activitys.findActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import findbookproject.k.findbook.FindBookApplication;
import findbookproject.k.findbook.R;
import findbookproject.k.findbook.data.watchedBook.WatchedBook;
import findbookproject.k.findbook.data.bookInfo.Items;
import findbookproject.k.findbook.activitys.findActivity.di.FindActivityModule;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class FindActivity extends AppCompatActivity implements FindActivityContract.View,FindActivityContract.BookListener {

    @Inject
    FindActivityContract.Presenter presenter;

    @BindView(R.id.ImageCover)
    ImageView imageViewCover;

    @BindView(R.id.book_recycler)
    RecyclerView bookRecycler;

    @BindView(R.id.searchEditText)
    EditText searchEditText;

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


        createShowCase();

        adapter = new FindAdapter(this);
        bookRecycler.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        bookRecycler.addItemDecoration(itemDecoration);
        bookRecycler.setHasFixedSize(true);
        bookRecycler.setAdapter(adapter);
        bookRecycler.setVisibility(View.INVISIBLE);


    }

    private void createShowCase() {
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "First");
        sequence.setConfig(config);

        sequence.addSequenceItem(searchEditText,
                "Here u can type what u looking for ", "GOT IT");

        sequence.addSequenceItem(searchButton,
                "This is button for Search", "GOT IT");
        sequence.start();
    }


    @OnClick(R.id.search_button)
    public void onSearchClick() {
       final Animation animButton = AnimationUtils.loadAnimation(this,R.anim.bounce);
        searchButton.startAnimation(animButton);
        presenter.searchForTextOrBook(searchEditText.getText().toString());
        searchEditText.clearFocus();

    }


    @Override
    public void showTextAfterEditTextSearchIsEmpty() {
        Toast.makeText(this, R.string.text_for_empty_edit_text_search, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setRecycler(List<Items> items) {
        adapter.updateBooks(items);
    }

    @Override
    public void setRecyclerVisible() {
        imageViewCover.setVisibility(View.INVISIBLE);
        bookRecycler.setVisibility(View.VISIBLE);
    }


    @Override
    public void passBookToDatabase(WatchedBook watchedBook) {
        presenter.saveBookToDatabase(watchedBook);
        Toast.makeText(this,"BookSaved",Toast.LENGTH_LONG).show();
    }
}



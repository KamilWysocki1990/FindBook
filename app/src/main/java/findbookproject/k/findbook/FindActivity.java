package findbookproject.k.findbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import findbookproject.k.findbook.data.ResponseBooks;
import findbookproject.k.findbook.network.Api;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private Api api;


    @BindView(R.id.searchEditText)
    EditText searchEditText;

    @BindView(R.id.textForShow)
    TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findbook);
        ButterKnife.bind(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(Api.class);

    }

    @OnClick(R.id.search_button)
    public void onSearchClick(){
        String searchText=searchEditText.getText().toString();

        if(searchText.isEmpty())
        {
            Toast.makeText(this,"Sorry:(, couldn't found what to search :(",Toast.LENGTH_LONG).show();
        } else {


            compositeDisposable.add(
                    api.getBook("volumes?q="+searchText)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            books-> textView.setText(books.getTotalBookAnserws().toString())
                    )
            );

        }

    }


}

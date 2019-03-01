package findbookproject.k.findbook;

import android.app.Application;

import dagger.android.support.DaggerAppCompatActivity;
import findbookproject.k.findbook.di.AppComponent;
import findbookproject.k.findbook.di.AppModule;
import findbookproject.k.findbook.di.DaggerAppComponent;
import findbookproject.k.findbook.di.DataModule;

public class FindBookApplication extends Application {

    private AppComponent appComponent;


    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
    }


}
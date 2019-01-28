package findbookproject.k.findbook.activitys.chosenBookActivity.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import findbookproject.k.findbook.activitys.chosenBookActivity.ChosenBookContract;
import findbookproject.k.findbook.activitys.chosenBookActivity.ChosenBookPresenter;

@Module
public class ChosenBookModule {

    ChosenBookContract.View view;


    public ChosenBookModule(ChosenBookContract.View view) {
        this.view = view;
    }


    @Provides
    @Singleton
    ChosenBookContract.Presenter provideChosenBookPresenter(){
        return new ChosenBookPresenter(view);
    }

}

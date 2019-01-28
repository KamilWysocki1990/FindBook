package findbookproject.k.findbook.activitys.chosenBookActivity.di;

import javax.inject.Singleton;

import dagger.Subcomponent;
import findbookproject.k.findbook.activitys.chosenBookActivity.ChosenBookActivity;
import findbookproject.k.findbook.activitys.findActivity.FindActivity;


@Singleton
@Subcomponent(modules = {ChosenBookModule.class})
public interface ChosenBookComponent {

    void inject(ChosenBookActivity chosenBookActivity);

}

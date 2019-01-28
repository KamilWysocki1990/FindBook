package findbookproject.k.findbook.activitys.findActivity.di;


import javax.inject.Singleton;

import dagger.Subcomponent;
import findbookproject.k.findbook.activitys.findActivity.FindActivity;

@Singleton
@Subcomponent(modules = {FindActivityModule.class})
public interface FindActivityComponent {

    void inject(FindActivity findActivity);

}

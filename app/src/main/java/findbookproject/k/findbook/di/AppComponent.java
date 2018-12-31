package findbookproject.k.findbook.di;

import dagger.Component;
import findbookproject.k.findbook.ApplicationScope;
import findbookproject.k.findbook.findActivity.di.FindActivityComponent;
import findbookproject.k.findbook.findActivity.di.FindActivityModule;

@ApplicationScope
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    FindActivityComponent plus (FindActivityModule findActivityModule);


}

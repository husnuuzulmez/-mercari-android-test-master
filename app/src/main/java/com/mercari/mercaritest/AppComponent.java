package com.mercari.mercaritest;


import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {
    void inject(MercariApp app);

    final class Initializer {
        static AppComponent init(MercariApp app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }

        private Initializer() {}
    }
}

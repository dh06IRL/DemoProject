package com.cartoaware.mvvm;

import android.app.Application;

import com.pixplicity.easyprefs.library.Prefs;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new Prefs.Builder()
                .setContext(this)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
}

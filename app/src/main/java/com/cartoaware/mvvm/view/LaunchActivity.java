package com.cartoaware.mvvm.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cartoaware.mvvm.utils.Constants;
import com.pixplicity.easyprefs.library.Prefs;

public class LaunchActivity extends AppCompatActivity {

    Intent intent;
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if(Prefs.getString(Constants.AUTH_TOKEN, null) != null){
            //go to discover
            intent = new Intent( mContext, MainActivity.class);
        }else{
            //auth activity
            intent = new Intent(mContext, AuthActivity.class);
        }
        startActivity(intent);
    }
}

package com.cartoaware.mvvm.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.cartoaware.mvvm.viewmodel.AuthViewModel;
import com.cartoaware.mvvmdemo.R;
import com.cartoaware.mvvmdemo.databinding.AuthActivityBinding;

public class AuthActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        AuthActivityBinding authActivityBinding = DataBindingUtil.setContentView(this,  R.layout.activity_auth);
        AuthViewModel authViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(AuthViewModel.class);

        authActivityBinding.authLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate length of email + password text (length > 0)
                //validate email format regex
                //validate password -> meets requirements
                authViewModel.authUser(authActivityBinding.authEmail.getText().toString(), authActivityBinding.authPassword.getText().toString());
                authViewModel.getAuthData().observe(AuthActivity.this, authResponse -> {
                    if(authResponse != null){
                        Intent discoverIntent = new Intent(mContext, MainActivity.class);
                        startActivity(discoverIntent);
                    }
                });
            }
        });
    }
}

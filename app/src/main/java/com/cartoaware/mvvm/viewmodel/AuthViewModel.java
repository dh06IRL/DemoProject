package com.cartoaware.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cartoaware.mvvm.data.AuthRepository;
import com.cartoaware.mvvm.model.AuthResponse;


public class AuthViewModel extends ViewModel {

    private MutableLiveData<AuthResponse> authResponseData = new MutableLiveData<>();
    private AuthRepository authRepository;

    public AuthViewModel(){
        this.authRepository = AuthRepository.getInstance();
    }

    public AuthViewModel(AuthRepository authRepositoryPassed){
        this.authRepository = authRepositoryPassed;
    }

    public void authUser(String email, String password){
        authResponseData = authRepository.authUser(email, password);
    }

    public LiveData<AuthResponse> getAuthData() {
        return authResponseData;
    }

    public AuthRepository getAuthRepository() {
        return authRepository;
    }

}


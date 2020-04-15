package com.cartoaware.mvvm.data;

import androidx.lifecycle.MutableLiveData;

import com.cartoaware.mvvm.model.AuthBody;
import com.cartoaware.mvvm.model.AuthResponse;
import com.cartoaware.mvvm.utils.Constants;
import com.pixplicity.easyprefs.library.Prefs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private static AuthRepository authRepository = new AuthRepository();
    private SearchApi searchApi = ApiService.createApiService(SearchApi.class);
    public static AuthRepository getInstance() {
        return authRepository;
    }

    public MutableLiveData<AuthResponse> authUser(String email, String password) {
        MutableLiveData<AuthResponse> authResponseData = new MutableLiveData<>();
        Call<AuthResponse> call = searchApi.authUser(new AuthBody(email, password));
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()) {
                    authResponseData.postValue(response.body());
                    Prefs.putString(Constants.AUTH_TOKEN, response.body().authToken);
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                authResponseData.postValue(null);
            }
        });
        return authResponseData;
    }
}

package com.cartoaware.mvvm.data;

import androidx.lifecycle.MutableLiveData;

import com.cartoaware.mvvm.model.Restaurant;
import com.cartoaware.mvvm.model.RestaurantDetail;
import com.cartoaware.mvvm.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantRepository {

    private static RestaurantRepository restaurantRepository = new RestaurantRepository();
    private SearchApi searchApi = ApiService.createApiService(SearchApi.class);

    public static RestaurantRepository getInstance() {
        return restaurantRepository;
    }

    public MutableLiveData<List<Restaurant>> getRestaurants(Double lat, Double lon) {
        MutableLiveData<List<Restaurant>> restaurantData = new MutableLiveData<>();
        Call<List<Restaurant>> call = searchApi.getRestaurants(lat,
                lon, Constants.API_DEFAULT_PAGE, Constants.API_PER_PAGE_LIMIT);
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                if (response.isSuccessful()) {
                    restaurantData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                restaurantData.setValue(null);
            }
        });
        return restaurantData;
    }

    public MutableLiveData<RestaurantDetail> getRestaurantDetails(long restaurantId) {
        MutableLiveData<RestaurantDetail> restaurantData = new MutableLiveData<>();
        Call<RestaurantDetail> call = searchApi.getRestaurantDetails(restaurantId);
        call.enqueue(new Callback<RestaurantDetail>() {
            @Override
            public void onResponse(Call<RestaurantDetail> call, Response<RestaurantDetail> response) {
                if (response.isSuccessful()) {
                    restaurantData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RestaurantDetail> call, Throwable t) {
                restaurantData.setValue(null);
            }
        });
        return restaurantData;
    }
}

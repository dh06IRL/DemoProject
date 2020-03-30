package com.cartoaware.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cartoaware.mvvm.model.RestaurantDetail;
import com.cartoaware.mvvm.data.RestaurantRepository;


public class RestaurantDetailViewModel extends ViewModel {

    private MutableLiveData<RestaurantDetail> restaurantDetailLiveData = new MutableLiveData<>();
    private RestaurantRepository restaurantRepository = RestaurantRepository.getInstance();

    public void fetchRestaurantDetails(long restaurantId){
        restaurantDetailLiveData = restaurantRepository.getRestaurantDetails(restaurantId);
    }

    public LiveData<RestaurantDetail> getRestaurantDetailsData() {
        return restaurantDetailLiveData;
    }

}

package com.cartoaware.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cartoaware.mvvm.model.Restaurant;
import com.cartoaware.mvvm.data.RestaurantRepository;

import java.util.List;

public class RestaurantsViewModel extends ViewModel  {

    private MutableLiveData<List<Restaurant>> restaurantLiveData = new MutableLiveData<>();
    private RestaurantRepository restaurantRepository;

    public RestaurantsViewModel(){
        this.restaurantRepository = RestaurantRepository.getInstance();
    }

    public RestaurantsViewModel(RestaurantRepository restaurantRepositoryPassed){
        this.restaurantRepository = restaurantRepositoryPassed;
    }

    public void fetchRestaurants(Double lat, Double lon){
        restaurantLiveData = restaurantRepository.getRestaurants(lat, lon);
    }

    public LiveData<List<Restaurant>> getRestaurantData() {
        return restaurantLiveData;
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

}


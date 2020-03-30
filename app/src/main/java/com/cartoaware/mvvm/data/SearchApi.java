package com.cartoaware.mvvm.data;

import com.cartoaware.mvvm.model.Restaurant;
import com.cartoaware.mvvm.model.RestaurantDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchApi {

    @GET("restaurant/")
    Call<List<Restaurant>> getRestaurants(@Query("lat") Double lat,
                                         @Query("lng") Double lon,
                                         @Query("offset") Integer offset,
                                         @Query("limit") Integer limit);

    @GET("restaurant/{restaurant_id}")
    Call<RestaurantDetail> getRestaurantDetails(@Path("restaurant_id") Long id);
}


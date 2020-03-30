package com.cartoaware.mvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cartoaware.mvvm.model.Restaurant;
import com.cartoaware.mvvm.utils.Constants;
import com.cartoaware.mvvm.view.RestaurantDetailsActivity;
import com.cartoaware.mvvmdemo.databinding.ViewRestaurantItemBinding;

import java.util.List;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.RestaurantPhotosViewHolder> {

    private List<Restaurant> restaurants;

    public RestaurantsAdapter(List<Restaurant> restaurantList) {
        this.restaurants = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantPhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewRestaurantItemBinding itemBinding = ViewRestaurantItemBinding.inflate(layoutInflater, parent, false);
        return new RestaurantPhotosViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantPhotosViewHolder holder, int position) {
        final Restaurant restaurant = restaurants.get(position);
        holder.bindRestaurant(restaurant);
    }

    @Override
    public int getItemCount() {
        return restaurants != null ? restaurants.size() : 0;
    }

    class RestaurantPhotosViewHolder extends RecyclerView.ViewHolder {
        private ViewRestaurantItemBinding restaurantItemBinding;

        RestaurantPhotosViewHolder(ViewRestaurantItemBinding binding) {
            super(binding.getRoot());
            this.restaurantItemBinding = binding;
        }

        void bindRestaurant(Restaurant restaurant) {
            restaurantItemBinding.setRestaurant(restaurant);
            restaurantItemBinding.setNavHandler((View v, long restaurantId, String restaurantName) -> {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, RestaurantDetailsActivity.class);
                        intent.putExtra(Constants.INTENT_RESTAURANT_ID, restaurantId);
                        intent.putExtra(Constants.INTENT_RESTAURANT_NAME, restaurantName);
                        context.startActivity(intent);
                    }
            );
            restaurantItemBinding.executePendingBindings();
        }
    }
}

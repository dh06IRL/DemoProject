package com.cartoaware.mvvm.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.cartoaware.mvvm.utils.Constants;
import com.cartoaware.mvvm.viewmodel.RestaurantDetailViewModel;
import com.cartoaware.mvvmdemo.R;
import com.cartoaware.mvvmdemo.databinding.ActivityRestaurantDetailsBinding;

public class RestaurantDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(Constants.INTENT_RESTAURANT_NAME));

        ActivityRestaurantDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_details);
        RestaurantDetailViewModel restaurantsViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RestaurantDetailViewModel.class);
        restaurantsViewModel.fetchRestaurantDetails(getIntent().getLongExtra(Constants.INTENT_RESTAURANT_ID, 0));
        restaurantsViewModel.getRestaurantDetailsData().observe(this, restaurantDetail -> {
            if (restaurantDetail != null) {
                binding.setRestaurant(restaurantDetail);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            RestaurantDetailsActivity.this.finish();
            return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }

}

package com.cartoaware.mvvm.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.cartoaware.mvvm.adapter.RestaurantsAdapter;
import com.cartoaware.mvvm.model.Restaurant;
import com.cartoaware.mvvm.utils.Constants;
import com.cartoaware.mvvm.viewmodel.RestaurantsViewModel;
import com.cartoaware.mvvmdemo.R;
import com.cartoaware.mvvmdemo.databinding.MainActivityBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Restaurant> restaurantsList = new ArrayList<>();
    private RestaurantsAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().setTitle(getString(R.string.main_title));

        RestaurantsViewModel restaurantsViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RestaurantsViewModel.class);
        restaurantsViewModel.fetchRestaurants(Constants.DEFAULT_LAT, Constants.DEFAULT_LON);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.restaurants_divider));
        binding.restaurantsRecyclerview.addItemDecoration(itemDecorator);
        binding.restaurantsRecyclerview.setHasFixedSize(true);

        restaurantAdapter = new RestaurantsAdapter(restaurantsList);
        binding.restaurantsRecyclerview.setAdapter(restaurantAdapter);

        restaurantsViewModel.getRestaurantData().observe(this, response -> {
            if (response != null) {
                restaurantsList.addAll(response);
                restaurantAdapter.notifyDataSetChanged();
                binding.restaurantsLoading.setVisibility(View.GONE);
            }
        });
    }
}

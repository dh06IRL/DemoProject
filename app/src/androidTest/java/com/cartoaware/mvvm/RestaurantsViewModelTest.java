package com.cartoaware.mvvm;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.cartoaware.mvvm.data.RestaurantRepository;
import com.cartoaware.mvvm.model.Restaurant;
import com.cartoaware.mvvm.utils.Constants;
import com.cartoaware.mvvm.viewmodel.RestaurantsViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

@RunWith(JUnit4.class)
public class RestaurantsViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutor = new InstantTaskExecutorRule();
    private RestaurantsViewModel viewModel;
    private RestaurantRepository repository;

    @Before
    public void init() {
        repository = mock(RestaurantRepository.class);
        viewModel = new RestaurantsViewModel(repository);
    }

    @Test
    public void empty() {
        Observer<List<Restaurant>> result = mock(Observer.class);
        viewModel.getRestaurantData().observeForever(result);
        verifyNoInteractions(repository);
    }

    @Test
    public void basic() {
        Observer<List<Restaurant>> result = mock(Observer.class);
        viewModel.getRestaurantData().observeForever(result);
        viewModel.fetchRestaurants(Constants.DEFAULT_LAT, Constants.DEFAULT_LON);
    }
}

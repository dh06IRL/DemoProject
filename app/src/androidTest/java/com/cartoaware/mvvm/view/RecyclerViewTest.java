package com.cartoaware.mvvm.view;

import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.cartoaware.mvvmdemo.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewTest {
    private MainActivity mActivity;
    private int resId = R.id.restaurants_recyclerview;
    private RecyclerView mRecyclerView;
    private int itemCount = 0;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class) {

        @Override
        protected Intent getActivityIntent() {
            return new Intent();
        }
    };

    @Before
    public void setUpTest() {

        this.mActivity = this.mActivityRule.getActivity();

        this.mRecyclerView = this.mActivity.findViewById(this.resId);
        this.itemCount = this.mRecyclerView.getAdapter().getItemCount();
    }

    @Test
    public void RecyclerViewTest() {
        if(this.itemCount > 0) {
            for(int i=0; i < this.itemCount; i++) {

                onView(withId(this.resId))
                        .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));

            }
        }
    }
}

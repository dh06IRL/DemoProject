package com.cartoaware.mvvm.bindings;

import android.location.Location;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.cartoaware.mvvm.utils.Constants;
import com.cartoaware.mvvm.utils.LocationUtils;
import com.cartoaware.mvvmdemo.R;
import com.pixplicity.easyprefs.library.Prefs;


public class BindingAdapterUtils {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imgUrl) {
        Glide.with(imageView.getContext())
                .load(imgUrl)
                .transition(DrawableTransitionOptions.withCrossFade(900))
                .error(R.mipmap.ic_doordash)
                .thumbnail(0.1f)
                .into(imageView);
    }

    @BindingAdapter({"imgLat", "imgLon"})
    public static void displayMapImage(ImageView imageView, Double lat, Double lon){
        if(lat != null && lon != null) {
            Glide.with(imageView.getContext())
                    .load(String.format(Constants.BASE_MAP_URL, lon, lat))
                    .transition(DrawableTransitionOptions.withCrossFade(900))
                    .transform(new RoundedCorners((int)imageView.getContext().getResources().getDimension(R.dimen.img_corner_radius)))
                    .thumbnail(0.1f)
                    .into(imageView);
        }
    }

    @BindingAdapter({"lat", "lon"})
    public static void calculateDistance(TextView textView, Double lat, Double lon){
        if(lat != null && lon != null) {
            Location rLocation = LocationUtils.locationBuilder(lat, lon);
            Location uLocation = LocationUtils.locationBuilder(Constants.DEFAULT_LAT, Constants.DEFAULT_LON);
            //Just a quick drop in, would further optimize + setup for translation support
            textView.setText(String.format("%.2f", rLocation.distanceTo(uLocation) * 0.00062137119) + "mi Away");
        }else{
            textView.setText("-");
        }
    }


    @BindingAdapter("restaurantId")
    public static void checkIfFav(Button button, Long restaurantId){
        if(!Prefs.getBoolean(Long.toString(restaurantId), false)){
            button.setText("Add Fav");
        }else{
            button.setText("Remove Fav");
        }
    }
}

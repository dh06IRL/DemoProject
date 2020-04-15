package com.cartoaware.mvvm.utils;

public class Constants {


    public static final String AUTH_TOKEN = "api_auth_token";

    public static final Integer API_DEFAULT_PAGE = 0;
    public static final Integer API_PER_PAGE_LIMIT = 200;

    //for debugging, would use live location in prod
    public static final Double DEFAULT_LAT = 37.422740;
    public static final Double DEFAULT_LON = -122.139956;

    public static final String INTENT_RESTAURANT_ID = "restaurantId";
    public static final String INTENT_RESTAURANT_NAME = "restaurantName";


    public static final String FAV_ITEMS = "restaurant_favs";

    public static final String BASE_MAP_URL = "https://api.mapbox.com/v4/mapbox.light/%1$f,%2$f,18/600x300@2x.png?access_token=pk.eyJ1Ijoia3RtZGF2aWQyMjkiLCJhIjoiY2s4ZXBwbGQ3MTgwMTNmcWN3NGl6MmMxcyJ9.pWaZrdOrHiA-MujnD0bcow";

}

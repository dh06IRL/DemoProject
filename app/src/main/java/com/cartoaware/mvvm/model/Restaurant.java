package com.cartoaware.mvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    @SerializedName("is_time_surging")
    @Expose
    public Boolean isTimeSurging;
    @SerializedName("delivery_fee")
    @Expose
    public Integer deliveryFee;
    @SerializedName("max_composite_score")
    @Expose
    public Integer maxCompositeScore;
    @SerializedName("id")
    @Expose
    public long id;
    @SerializedName("average_rating")
    @Expose
    public Double averageRating;
    @SerializedName("composite_score")
    @Expose
    public Integer compositeScore;
    @SerializedName("status_type")
    @Expose
    public String statusType;
    @SerializedName("is_only_catering")
    @Expose
    public Boolean isOnlyCatering;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("number_of_ratings")
    @Expose
    public Integer numberOfRatings;
    @SerializedName("asap_time")
    @Expose
    public Integer asapTime;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("business")
    @Expose
    public Business business;
    @SerializedName("tags")
    @Expose
    public List<String> tags = new ArrayList<>();
    @SerializedName("yelp_review_count")
    @Expose
    public Integer yelpReviewCount;
    @SerializedName("business_id")
    @Expose
    public Integer businessId;
    @SerializedName("extra_sos_delivery_fee")
    @Expose
    public Integer extraSosDeliveryFee;
    @SerializedName("yelp_rating")
    @Expose
    public Double yelpRating;
    @SerializedName("cover_img_url")
    @Expose
    public String coverImgUrl;
    @SerializedName("header_img_url")
    @Expose
    public String headerImgUrl;
    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("price_range")
    @Expose
    public Integer priceRange;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("is_newly_added")
    @Expose
    public Boolean isNewlyAdded;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("service_rate")
    @Expose
    public Double serviceRate;

}

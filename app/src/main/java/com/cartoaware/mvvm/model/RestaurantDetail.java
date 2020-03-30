package com.cartoaware.mvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetail {
    @SerializedName("phone_number")
    @Expose
    public String phoneNumber;
    @SerializedName("yelp_review_count")
    @Expose
    public Integer yelpReviewCount;
    @SerializedName("is_consumer_subscription_eligible")
    @Expose
    public Boolean isConsumerSubscriptionEligible;
    @SerializedName("offers_delivery")
    @Expose
    public Boolean offersDelivery;
    @SerializedName("delivery_fee")
    @Expose
    public Integer deliveryFee;
    @SerializedName("max_composite_score")
    @Expose
    public Integer maxCompositeScore;
    @SerializedName("provides_external_courier_tracking")
    @Expose
    public Boolean providesExternalCourierTracking;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("average_rating")
    @Expose
    public Double averageRating;
    @SerializedName("tags")
    @Expose
    public List<String> tags = new ArrayList<>();
    @SerializedName("delivery_radius")
    @Expose
    public Integer deliveryRadius;
    @SerializedName("inflation_rate")
    @Expose
    public Double inflationRate;
    @SerializedName("show_store_menu_header_photo")
    @Expose
    public Boolean showStoreMenuHeaderPhoto;
    @SerializedName("composite_score")
    @Expose
    public Integer compositeScore;
    @SerializedName("fulfills_own_deliveries")
    @Expose
    public Boolean fulfillsOwnDeliveries;
    @SerializedName("offers_pickup")
    @Expose
    public Boolean offersPickup;
    @SerializedName("number_of_ratings")
    @Expose
    public Integer numberOfRatings;
    @SerializedName("status_type")
    @Expose
    public String statusType;
    @SerializedName("is_only_catering")
    @Expose
    public Boolean isOnlyCatering;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("object_type")
    @Expose
    public String objectType;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("business")
    @Expose
    public Business business;
    @SerializedName("yelp_biz_id")
    @Expose
    public String yelpBizId;
    @SerializedName("should_show_store_logo")
    @Expose
    public Boolean shouldShowStoreLogo;
    @SerializedName("yelp_rating")
    @Expose
    public Double yelpRating;
    @SerializedName("extra_sos_delivery_fee")
    @Expose
    public Integer extraSosDeliveryFee;
    @SerializedName("business_id")
    @Expose
    public Integer businessId;
    @SerializedName("cover_img_url")
    @Expose
    public String coverImgUrl;
    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("price_range")
    @Expose
    public Integer priceRange;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("show_suggested_items")
    @Expose
    public Boolean showSuggestedItems;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("is_newly_added")
    @Expose
    public Boolean isNewlyAdded;
    @SerializedName("is_good_for_group_orders")
    @Expose
    public Boolean isGoodForGroupOrders;
    @SerializedName("service_rate")
    @Expose
    public Double serviceRate;
    @SerializedName("header_image_url")
    @Expose
    public String headerImageUrl;

}

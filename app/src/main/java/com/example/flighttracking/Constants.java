package com.example.flighttracking;

import com.example.flighttracking.BuildConfig;

public final class Constants {
    public static final String AIR_BASE_URL = "https://airlabs.co/api/v9/";
    public static final String AIR_API_KEY = BuildConfig.AIR_API_KEY;
    public static final String PREFERENCES_LOCATION_KEY = "country";
    public static final String FIREBASE_CHILD_SEARCHED_LOCATION = "searchedCountry";
    public static final String FIREBASE_CHILD_AIRPORTS = "airports";
    public static final String FIREBASE_QUERY_INDEX = "index";
    public static final String EXTRA_KEY_POSITION = "position";
    public static final String EXTRA_KEY_AIRPORTS = "airports";
    public static final String KEY_SOURCE = "source";
    public static final String SOURCE_SAVED = "saved";
    public static final String SOURCE_FIND = "find";
}

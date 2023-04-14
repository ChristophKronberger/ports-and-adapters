package com.schmeisky.apikata.adapters;

import com.google.gson.annotations.SerializedName;

/**
 * Documentation of JSON format: see <a href="softly.">here</a>.
 */
public record ApiWeatherData(int id, String name, @SerializedName("time") String timeStamp, @SerializedName("T") String temperature, @SerializedName("P") String pressure, @SerializedName("D") String windDirection) {

}

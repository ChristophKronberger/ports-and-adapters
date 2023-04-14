package com.schmeisky.apikata.ports;

import com.schmeisky.apikata.business.WeatherApp;

public interface WeatherFetchTriggerPort {

    /**
     * Allow setting of back-reference to the app after construction
     */
    void setApp(WeatherApp weatherApp);

    void fetch();

}

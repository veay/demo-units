package com.lee.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jackl on 2017.8.5.
 */
@Component
public class ProfilesProperty {


    @Value("${app.profiles}")
    private String app_profiles;

    public String getApp_profiles() {
        return app_profiles;
    }


    @Override
    public String toString() {
        return "ProfilesProperty{" +
                "app_profiles='" + app_profiles + '\'' +
                '}';
    }
}

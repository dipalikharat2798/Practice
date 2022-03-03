package com.geico.adexpress.model;

import com.geico.adexpress.utility.FirebaseContract;

import java.io.Serializable;

public class FirebaseUserDetailsPojo implements Serializable {

    //    public String TIME_STAMP_UTC = FirebaseContract.Events.TIME_STAMP_UTC;
    public String DEVICE_BRAND_MODEL = FirebaseContract.UserProfile.DEVICE_BRAND_MODEL;
    public String OS_VERSION = FirebaseContract.UserProfile.OS_VERSION;
    public String USER_NAME = FirebaseContract.UserProfile.USER_NAME;
    public String LAST_LOGIN = FirebaseContract.LastActivities.LAST_LOGIN;
    public String LAST_ACTION = FirebaseContract.LastActivities.LAST_ACTION;
    public String APP_VERSION = FirebaseContract.UserProfile.APP_VERSION;
    public String USERID = FirebaseContract.UserProfile.USERID;

    public FirebaseUserDetailsPojo() {

    }

    public FirebaseUserDetailsPojo(String DEVICE_BRAND_MODEL, String OS_VERSION, String USER_NAME, String userId, String LAST_LOGIN, String LAST_ACTION, String APP_VERSION) {
//        this.TIME_STAMP_UTC = TIME_STAMP_UTC;
        this.DEVICE_BRAND_MODEL = DEVICE_BRAND_MODEL;
        this.OS_VERSION = OS_VERSION;
        this.USER_NAME = USER_NAME;
        this.LAST_LOGIN = LAST_LOGIN;
        this.LAST_ACTION = LAST_ACTION;
        this.APP_VERSION = APP_VERSION;
        this.USERID = userId;
    }
}
package com.geico.adexpress.model;

public class model {
   private String DEVICE_BRAND_MODEL = "DEVICE_BRAND_MODEL";
   private String OS_VERSION = "OS_VERSION";
   private String USER_NAME = "USER_NAME";
   private String APP_VERSION = "APP_VERSION";
   private String USERID = "USERID";
   private String LAST_LOGIN = "LAST_LOGIN";
   private String LAST_ACTION = "LAST_ACTION";
   private String USER_PROFILE = "USER_PROFILE";

    public model() {
    }

    public model(String DEVICE_BRAND_MODEL, String OS_VERSION, String USER_NAME, String APP_VERSION, String USERID, String LAST_LOGIN, String LAST_ACTION, String USER_PROFILE) {
        this.DEVICE_BRAND_MODEL = DEVICE_BRAND_MODEL;
        this.OS_VERSION = OS_VERSION;
        this.USER_NAME = USER_NAME;
        this.APP_VERSION = APP_VERSION;
        this.USERID = USERID;
        this.LAST_LOGIN = LAST_LOGIN;
        this.LAST_ACTION = LAST_ACTION;
        this.USER_PROFILE = USER_PROFILE;
    }

    public String getDEVICE_BRAND_MODEL() {
        return DEVICE_BRAND_MODEL;
    }

    public void setDEVICE_BRAND_MODEL(String DEVICE_BRAND_MODEL) {
        this.DEVICE_BRAND_MODEL = DEVICE_BRAND_MODEL;
    }

    public String getOS_VERSION() {
        return OS_VERSION;
    }

    public void setOS_VERSION(String OS_VERSION) {
        this.OS_VERSION = OS_VERSION;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getAPP_VERSION() {
        return APP_VERSION;
    }

    public void setAPP_VERSION(String APP_VERSION) {
        this.APP_VERSION = APP_VERSION;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getLAST_LOGIN() {
        return LAST_LOGIN;
    }

    public void setLAST_LOGIN(String LAST_LOGIN) {
        this.LAST_LOGIN = LAST_LOGIN;
    }

    public String getLAST_ACTION() {
        return LAST_ACTION;
    }

    public void setLAST_ACTION(String LAST_ACTION) {
        this.LAST_ACTION = LAST_ACTION;
    }

    public String getUSER_PROFILE() {
        return USER_PROFILE;
    }

    public void setUSER_PROFILE(String USER_PROFILE) {
        this.USER_PROFILE = USER_PROFILE;
    }
}

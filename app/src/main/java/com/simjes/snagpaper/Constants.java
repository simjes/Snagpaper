package com.simjes.snagpaper;

public class Constants {
    public static final String LOG_TAG = "imgurapp";

    private static final String MY_IMGUR_CLIENT_ID = "";
    public static final String MY_IMGUR_CLIENT_SECRET = "";

    public static final String MY_IMGUR_REDIRECT_URL = "http://android";

    public static String getClientAuth() {
        return "Client-ID " + MY_IMGUR_CLIENT_ID;
    }
}

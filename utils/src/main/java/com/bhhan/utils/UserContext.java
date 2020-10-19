package com.bhhan.utils;

/**
 * Created by hbh5274@gmail.com on 2020-10-19
 * Github : http://github.com/bhhan5274
 */

public class UserContext {
    public static final String AUTH_TOKEN     = "Authorization";
    private String authToken;

    public String getAuthToken() { return authToken; }
    public void setAuthToken(String aToken) {authToken = aToken;}
}

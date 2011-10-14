package com.gwtmobile.phonegap.client.plugins.iphone.sharekit;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 9/26/11
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ShareService {
    void share(String message, String url);

    void isLoggedToTwitter(ShareKitCallback callback);

    void isLoggedToFacebook(ShareKitCallback callback);

    void logoutFromTwitter();

    void logoutFromFacebook();

    void facebookConnect();

    void shareToFacebook(String message, String url);
}

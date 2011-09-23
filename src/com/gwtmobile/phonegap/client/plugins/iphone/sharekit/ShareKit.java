package com.gwtmobile.phonegap.client.plugins.iphone.sharekit;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 9/23/11
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShareKit {

    private JavaScriptObject shareKit;
    private EventBus eventBus = new SimpleEventBus();

    public ShareKit(){
        shareKit = getShareKitNative();
    }

    public void share(String message, String url){
        share(shareKit, message, url);
    }

    public void isLoggedToTwitter(ShareKitCallback callback){
        isLoggedToTwitter(shareKit, callback);

    }

    public void isLoggedToFacebook(ShareKitCallback callback){
        isLoggedToFacebook(shareKit, callback);
    }

    public void logoutFromTwitter(){
        logoutFromTwitter(shareKit);
    }

    public void logoutFromFacebook(){
        logoutFromFacebook(shareKit);
    }

    public void facebookConnect(){
        facebookConnect(shareKit);
    }

    public void shareToFacebook(String message, String url){
        shareToFacebook(shareKit, message, url);
    }

    private native void share(JavaScriptObject shareKit, String message, String url)/*-{
        shareKit.share(message, url);
    }-*/;

    private native void isLoggedToTwitter(JavaScriptObject shareKit, ShareKitCallback callback)/*-{
        shareKit.isLoggedToTwitter(
                function(isLogged){
                    callback.@com.gwtmobile.phonegap.client.plugins.iphone.sharekit.ShareKitCallback::success(Z)(isLogged);
                }
        );
    }-*/;

    private native void isLoggedToFacebook(JavaScriptObject shareKit, ShareKitCallback callback)/*-{
        shareKit.isLoggedToFacebook(
                function(isLogged){
                    callback.@com.gwtmobile.phonegap.client.plugins.iphone.sharekit.ShareKitCallback::success(Z)(isLogged);
                }
        )
    }-*/;

    private native void logoutFromTwitter(JavaScriptObject shareKit)/*-{
        shareKit.logoutFromTwitter();
    }-*/;

    private native void logoutFromFacebook(JavaScriptObject shareKit)/*-{
        shareKit.logoutFromFacebook();
    }-*/;

    private native void facebookConnect(JavaScriptObject shareKit)/*-{
        shareKit.facebookConnect();
    }-*/;

    private native void shareToFacebook(JavaScriptObject shareKit, String message, String url)/*-{
        sahreKit.shareToFacebook(message, url);
    }-*/;


    private native JavaScriptObject getShareKitNative()/*-{
        return $wnd.plugins.shareKit;
    }-*/;
}

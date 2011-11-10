package com.gwtmobile.phonegap.client.plugins.iphone.customUrl;

import com.gwtmobile.phonegap.client.Event;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 11/8/11
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomUrl {

    public interface UrlReceivedCallback {
        void onUrlReceived(String url);
    }

    private static Logger logger = Logger.getLogger(CustomUrl.class.getName());


    public static void onDeviceReady(final UrlReceivedCallback callback){
        Event.onDeviceReady(new Event.Callback() {
            public void onEventFired() {
                nativeOnDeviceReady(callback);
            }
        });
    }

    private static native void nativeOnDeviceReady(UrlReceivedCallback callback)/*-{
        if($wnd.invokeString != null){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.customUrl.CustomUrl.UrlReceivedCallback::onUrlReceived(Ljava/lang/String;)($wnd.invokeString);
        }else{
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.customUrl.CustomUrl.UrlReceivedCallback::onUrlReceived(Ljava/lang/String;)(null);
        }
    }-*/;

    public static native void onResumedWithUrl(UrlReceivedCallback callback)/*-{
        $wnd.handleOpenURL = function(url){
            $entry(callback.@com.gwtmobile.phonegap.client.plugins.iphone.customUrl.CustomUrl.UrlReceivedCallback::onUrlReceived(Ljava/lang/String;)(url));
        }

    }-*/;




}

package com.gwtmobile.phonegap.client.plugins.notificationex;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/25/11
 * Time: 1:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationEx {

    public static native void loadingStart()/*-{
        $wnd.navigator.notificationEx.loadingStart();
    }-*/;

    public static native void loadingStop()/*-{
        $wnd.navigator.notificationEx.loadingStop();
    }-*/;

    public static native void activityStart()/*-{
        $wnd.navigator.notificationEx.activityStart();
    }-*/;

    public static native void activityStop()/*-{
        $wnd.navigator.notificationEx.activityStop();
    }-*/;
}

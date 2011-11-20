package com.gwtmobile.phonegap.client.plugins.iphone.testflight;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 11/20/11
 * Time: 2:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestFlight {

    public interface SuccessCallback {
        void onSuccess(String callbackId);
    }

    public interface FailureCallback {
        void onFailure(String message);
    }

    public static native void addCustomEnvironmentInformation(SuccessCallback successCallback, FailureCallback failureCallback,
                                                              String key, String information)/*-{
        $wnd.plugins.TestFlight.addCustomEnvironmentInformation(function(messageID){
            successCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.SuccessCallback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            failureCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.FailureCallback::onFailure(Ljava/lang/String;)(errorMessage);
        }, key, information);
    }-*/;

    public static native void takeOff(SuccessCallback successCallback, FailureCallback failureCallback, String teamToken)/*-{
        $wnd.plugins.TestFlight.takeOff(function(messageID){
            successCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.SuccessCallback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            failureCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.FailureCallback::onFailure(Ljava/lang/String;)(errorMessage);
        }, teamToken);
    }-*/;

    public static native void passCheckpoint(SuccessCallback successCallback, FailureCallback failureCallback, String checkpointName)/*-{
        $wnd.plugins.TestFlight.passCheckpoint(function(messageID){
            successCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.SuccessCallback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            failureCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.FailureCallback::onFailure(Ljava/lang/String;)(errorMessage);
        }, checkpointName);
    }-*/;

    public static native void openFeedbackView(SuccessCallback successCallback, FailureCallback failureCallback)/*-{
        $wnd.plugins.TestFlight.openFeedbackView(function(messageID){
            successCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.SuccessCallback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            failureCallback.@com.gwtmobile.phonegap.client.plugins.iphone.testflight.TestFlight.FailureCallback::onFailure(Ljava/lang/String;)(errorMessage);
        });
    }-*/;
}


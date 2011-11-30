package com.gwtmobile.phonegap.client.plugins.iphone.testflight;

/* Copyright (c) 2011 Smithimage (Robert Wallström)
 *
 * author: Robert Wallström
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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


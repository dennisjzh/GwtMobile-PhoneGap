package com.gwtmobile.phonegap.client.plugins.iphone;

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

    public interface Callback {
        void onSuccess(String callbackId);
        void onFailure(String message);
    }

    public static native void addCustomEnvironmentInformation(String key, String information, Callback callback)/*-{
        $wnd.plugins.TestFlight.addCustomEnvironmentInformation(function(messageID){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onFailure(Ljava/lang/String;)(errorMessage);
        }, key, information);
    }-*/;

    public static native void takeOff(String teamToken, Callback callback)/*-{
        $wnd.plugins.TestFlight.takeOff(function(messageID){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onFailure(Ljava/lang/String;)(errorMessage);
        }, teamToken);
    }-*/;

    public static native void passCheckpoint(String checkpointName, Callback callback)/*-{
        $wnd.plugins.TestFlight.passCheckpoint(function(messageID){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onFailure(Ljava/lang/String;)(errorMessage);
        }, checkpointName);
    }-*/;

    public static native void openFeedbackView(Callback callback)/*-{
        $wnd.plugins.TestFlight.openFeedbackView(function(messageID){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onSuccess(Ljava/lang/String;)(messageID);
        },
        function(errorMessage){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.TestFlight.Callback::onFailure(Ljava/lang/String;)(errorMessage);
        });
    }-*/;
}


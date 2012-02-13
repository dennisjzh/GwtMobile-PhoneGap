package com.gwtmobile.phonegap.client.plugins.iphone;

import com.gwtmobile.phonegap.client.Events;

import java.util.logging.Logger;

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
public class CustomUrl {

    public interface UrlReceivedCallback {
        void onUrlReceived(String url);
    }

    private static Logger logger = Logger.getLogger(CustomUrl.class.getName());


    public static void onDeviceReady(final UrlReceivedCallback callback){
        Events.onDeviceReady(new Events.Callback() {
            @Override
			public void onEventFired() {
                nativeOnDeviceReady(callback);
            }
        });
    }

    private static native void nativeOnDeviceReady(UrlReceivedCallback callback)/*-{
        if($wnd.invokeString != null){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.CustomUrl.UrlReceivedCallback::onUrlReceived(Ljava/lang/String;)($wnd.invokeString);
        }else{
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.CustomUrl.UrlReceivedCallback::onUrlReceived(Ljava/lang/String;)(null);
        }
    }-*/;

    public static native void onResumedWithUrl(UrlReceivedCallback callback)/*-{
        $wnd.handleOpenURL = function(url){
            $entry(callback.@com.gwtmobile.phonegap.client.plugins.iphone.CustomUrl.UrlReceivedCallback::onUrlReceived(Ljava/lang/String;)(url));
        }

    }-*/;




}

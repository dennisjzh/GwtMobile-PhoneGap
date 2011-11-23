package com.gwtmobile.phonegap.client.plugins.iphone.sharekit;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

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
public class ShareKit implements ShareService {

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

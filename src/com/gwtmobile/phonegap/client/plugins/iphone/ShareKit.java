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
package com.gwtmobile.phonegap.client.plugins.iphone;

public class ShareKit {

    public static native void share(String message, String url)/*-{
        $wnd.plugins.shareKit.share(message, url);
    }-*/;

    public static native void isLoggedToTwitter(Callback callback)/*-{
        $wnd.plugins.shareKit.isLoggedToTwitter(
                function(isLogged){
                    callback.@com.gwtmobile.phonegap.client.plugins.iphone.ShareKit.Callback::onSuccess(Z)(isLogged);
                }
        );
    }-*/;

    public static native void isLoggedToFacebook(Callback callback)/*-{
        $wnd.plugins.shareKit.isLoggedToFacebook(
                function(isLogged){
                    callback.@com.gwtmobile.phonegap.client.plugins.iphone.ShareKit.Callback::onSuccess(Z)(isLogged);
                }
        )
    }-*/;

    public static native void logoutFromTwitter()/*-{
        $wnd.plugins.shareKit.logoutFromTwitter();
    }-*/;

    public static native void logoutFromFacebook()/*-{
        $wnd.plugins.shareKit.logoutFromFacebook();
    }-*/;

    public static native void facebookConnect()/*-{
        $wnd.plugins.shareKit.facebookConnect();
    }-*/;

    public static native void shareToFacebook(String message, String url)/*-{
        $wnd.plugins.shareKit.shareToFacebook(message, url);
    }-*/;


    public interface Callback {
        void onSuccess(boolean isLogged);
    }

}

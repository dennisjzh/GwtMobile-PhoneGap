/*
 * Copyright (c) 2011 Zhihua (Dennis) Jiang
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

package com.gwtmobile.phonegap.client.plugins;

import com.gwtmobile.phonegap.client.Utils;


public class ChildBrowser {

	private static EventHandler eventHandler;

	static {
		if (Utils.isIOS()) {
			install();
		}
		initCallbacks();
	}
    		  	
    private native static void install() /*-{
        $wnd.ChildBrowser.install();
    }-*/;
    
    private native static void initCallbacks() /*-{
        $wnd.plugins.childBrowser.onLocationChange = function(loc) {
            @com.gwtmobile.phonegap.client.plugins.ChildBrowser::onLocationChange(Ljava/lang/String;)(loc);
        };
        $wnd.plugins.childBrowser.onClose = function() {
            @com.gwtmobile.phonegap.client.plugins.ChildBrowser::onClose()();
        };
        $wnd.plugins.childBrowser.onOpenExternal = function() {
            @com.gwtmobile.phonegap.client.plugins.ChildBrowser::onOpenExternal()();
        };

    }-*/;

    public static native void showWebPage(String url) /*-{
        $wnd.plugins.childBrowser.showWebPage(url);
    }-*/;

    public static native void close() /*-{
        $wnd.plugins.childBrowser.close();
    }-*/;


    private static void onClose() {
    	if (eventHandler != null) {
    		eventHandler.onClose();
    	}
    }

    private static void onOpenExternal() {
    	if (eventHandler != null) {
    		eventHandler.onOpenExternal();
    	}
    }

    private static void onLocationChange(String url) {
    	if (eventHandler != null) {
    		eventHandler.onLocationChange(url);
    	}
    }

    public static interface EventHandler {
        void onClose();
        void onOpenExternal();
        void onLocationChange(String url);
    }

    public static void setEventHandler(EventHandler eventHandler) {
    	ChildBrowser.eventHandler = eventHandler;
    }
    
    public static EventHandler getEventHandler() {
    	return ChildBrowser.eventHandler; 
    }
    
}

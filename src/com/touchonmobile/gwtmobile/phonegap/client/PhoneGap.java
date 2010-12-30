/*
 * Copyright (c) 2010 Zhihua (Dennis) Jiang
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

package com.touchonmobile.gwtmobile.phonegap.client;



public class PhoneGap {
    
	public native static void onDeviceReady(Callback callback) /*-{
		//PhoneGap uses "instanceof Function". Have to use callbackproxy to get around.
	    $doc.addEventListener("deviceready", new $wnd.callbackproxy(function() {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.PhoneGap.Callback::onEventFired()();
	    }).callback, false);
	}-*/;
	
	public native static void onPause(Callback callback) /*-{
	    $doc.addEventListener("pause", new $wnd.callbackproxy(function() {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.PhoneGap.Callback::onEventFired()();
	    }).callback, false);
	}-*/;

	public native static void onResume(Callback callback) /*-{
	    $doc.addEventListener("resume", new $wnd.callbackproxy(function() {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.PhoneGap.Callback::onEventFired()();
	    }).callback, false);
	}-*/;

	public interface Callback {
		public void onEventFired();
	}
}

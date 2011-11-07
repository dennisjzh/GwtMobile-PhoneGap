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

import com.google.gwt.core.client.JavaScriptObject;


public class Facebook {
	
	public native static String init(String appId) /*-{
		return $wnd.FB.init({appId: appId, nativeInterface: $wnd.PG.FB});
	}-*/;
	
	public native void login(Callback callback, String permissions) /*-{
	    $wnd.FB.login(function(response){
		    callback.@com.gwtmobile.phonegap.client.plugins.Facebook.Callback::onSuccess(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
		}, {perms:permissions});
	}-*/;

	public native void logout(Callback callback) /*-{
	    $wnd.FB.logout(function(response){
		    callback.@com.gwtmobile.phonegap.client.plugins.Facebook.Callback::onSuccess(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
		});
	}-*/;

	public native void getLoginStatus(Callback callback) /*-{
    $wnd.FB.getLoginStatus(function(response){
	    callback.@com.gwtmobile.phonegap.client.plugins.Facebook.Callback::onSuccess(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
	});
}-*/;

	public interface Callback {
		void onSuccess(JavaScriptObject response);
	}

}

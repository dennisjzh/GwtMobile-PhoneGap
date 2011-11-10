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

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;


public class Facebook {
	
	public native static String init(String appId) /*-{
		return $wnd.FB.init({appId: appId, nativeInterface: $wnd.PG.FB});
	}-*/;
	
	public native static void login(Callback callback, String permissions) /*-{
	    $wnd.FB.login(function(response) {
		    callback.@com.gwtmobile.phonegap.client.plugins.Facebook.Callback::onSuccess(Lcom/gwtmobile/phonegap/client/plugins/Facebook$Response;)(response);
		}, {perms:permissions});
	}-*/;

	public native static void logout(Callback callback) /*-{
	    $wnd.FB.logout(function(response) {
		    callback.@com.gwtmobile.phonegap.client.plugins.Facebook.Callback::onSuccess(Lcom/gwtmobile/phonegap/client/plugins/Facebook$Response;)(response);
		});
	}-*/;

	public native static void getLoginStatus(Callback callback) /*-{
	    $wnd.FB.getLoginStatus(function(response) {
		    callback.@com.gwtmobile.phonegap.client.plugins.Facebook.Callback::onSuccess(Lcom/gwtmobile/phonegap/client/plugins/Facebook$Response;)(response);
		});
	}-*/;
	
	public native static void api(String path, String method, Params params, Callback callback) /*-{
		$wnd.FB.api(path, method, params, function(response) {
		    callback.@com.gwtmobile.phonegap.client.plugins.Facebook.Callback::onSuccess(Lcom/gwtmobile/phonegap/client/plugins/Facebook$Response;)(response);
		});
	}-*/;

	public interface Callback {
		void onSuccess(Response response);
	}

	public static class Response extends JavaScriptObject {
		
		protected Response() {}

		public final native String getStatus() /*-{
			if (typeof this.status != "undefined")
				return this.status;
			return null;
		}-*/;

		public final native Session getSession() /*-{
			if (typeof this.session != "undefined")
				return this.session;
			return null;
		}-*/;
		
		public final native String get(String key) /*-{
			if (typeof this[key] != "undefined")
				return this[key];
			return null;
		}-*/;
			
	}

	public static class Session extends JavaScriptObject {
		
		protected Session() {}
		
		public final native String getAccessToken() /*-{
			return this.access_token;
		}-*/;

		public final Date getExpiresIn() {
			return new Date((long) getExpiresInNative());
		}
		
		private final native double getExpiresInNative() /*-{
			return this.expires;
		}-*/;
		
		public final native String getSignedRequest() /*-{
			return this.sig;
		}-*/;

		public final native String getUserID() /*-{
			return this.uid;
		}-*/;
	}
	
	public static class Params extends JavaScriptObject {
		
		protected Params() {}
		
		public final static Params createParams() {
			return (Params) JavaScriptObject.createObject();
		}

		public final native void set(String key, String value) /*-{
			this[key] = value;
		}-*/;
		
		public final native String get(String key) /*-{
			if (typeof this[key] != "undefined")
				return this[key];
			return null;
		}-*/;
	}

}

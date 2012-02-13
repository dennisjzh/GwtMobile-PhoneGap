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

package com.gwtmobile.phonegap.client;

import com.google.gwt.core.client.JavaScriptObject;

public class App {

	// below are Android specific APIs.	
	
	public native static void exitApp() /*-{
		if ($wnd.navigator.app && typeof $wnd.navigator.app.exitApp == "function") {
			$wnd.navigator.app.exitApp();
		}
	}-*/;

	public native static void loadUrl(String url, LoadUrlOptions options) /*-{
		if ($wnd.navigator.app && typeof $wnd.navigator.app.loadUrl == "function") {
			$wnd.navigator.app.loadUrl(url, options);
		}
	}-*/;

	public final static class LoadUrlOptions extends JavaScriptObject {

		protected LoadUrlOptions() {};
		
		public final static LoadUrlOptions newInstance() {
			return (LoadUrlOptions) JavaScriptObject.createObject();
		}

		public final native LoadUrlOptions wait(int time) /*-{
			this.wait = time;
			return this;
		}-*/;

		public native LoadUrlOptions openExternal(boolean external) /*-{
			this.openexternal = external;
			return this;
		}-*/;

		public native LoadUrlOptions clearHistory(boolean clear) /*-{
			this.clearhistory = clear;
			return this;
		}-*/;

	}

}

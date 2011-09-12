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
import com.google.gwt.core.client.JsArray;


public class Capture {

	public native static JsArray<ConfigurationData> getSupportedAudioModes() /*-{
		return this.supportedAudioModes;
	}-*/;
	
	public native static JsArray<ConfigurationData> getSupportedImageModes() /*-{
		return this.supportedImageModes;
	}-*/;
	
	public native static JsArray<ConfigurationData> getSupportedVideoModes() /*-{
		return this.supportedVideoModes;
	}-*/;
	
	
	public static class ConfigurationData extends JavaScriptObject {
			
			protected ConfigurationData() {}
			
			public final native String getType() /*-{
				return this.type;
			}-*/;

			public final native int getHeight() /*-{
				return this.height;
			}-*/;

			public final native int getWidth() /*-{
				return this.width;
			}-*/;
	}
}

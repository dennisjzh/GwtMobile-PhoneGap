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

package com.gwtmobile.phonegap.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Camera {

	public static void getPicture(Callback callback) {
		getPicture(callback, null);
	}

	public native static void getPicture(Callback callback, Options options) /*-{
		$wnd.navigator.camera.getPicture(function(imageData) {
	    	callback.@com.gwtmobile.phonegap.client.Camera.Callback::onSuccess(Ljava/lang/String;)(imageData);
	    }, function(message) {
	    	callback.@com.gwtmobile.phonegap.client.Camera.Callback::onError(Ljava/lang/String;)(message);
		}, options);
	}-*/;
	
	public interface Callback {
		void onSuccess(String imageData);
		void onError(String message); 
	}
	
	public enum DestinationType { DATA_URL, FILE_URI }

	public enum SourceType { PHOTOLIBRARY, CAMERA, SAVEDPHOTOALBUM }
	
	public enum EncodingType { JPEG, PNG }
	
	public enum MediaType { PICTURE, VIDEO, ALLMEDIA }
	
    public static class Options extends JavaScriptObject {
    	
    	protected Options() {};

    	public static Options newInstance() {
    		return (Options) JavaScriptObject.createObject();
    	}
    	
    	public final native Options quality(int q) /*-{
    		this.quality = q;
    		return this;
		}-*/;

    	// TODO: is there way to pass enum to javascript without using this method?
    	public final Options destinationType(DestinationType d) {
    		return destinationType(d.ordinal());
    	}
    	
    	private final native Options destinationType(int d) /*-{
			this.destinationType = d;			
    		return this;
		}-*/;

    	public final Options sourceType(SourceType s) {
    		return sourceType(s.ordinal());
    	}
    	
    	private final native Options sourceType(int s) /*-{
			this.sourceType = s;			
    		return this;
		}-*/;

    	public final native Options allowEdit(boolean b) /*-{
			this.allowEdit = b;			
    		return this;
		}-*/;

    	public final Options encodingType(EncodingType e) {
    		return encodingType(e.ordinal());
    	}
    	
    	private final native Options encodingType(int e) /*-{
			this.encodingType = e;			
    		return this;
		}-*/;
    	
    	public final native Options targetWidth(int w) /*-{
			this.targetWidth = w;
			return this;
		}-*/;

    	public final native Options targetHeight(int h) /*-{
			this.targetHeight = h;
			return this;
		}-*/;

    	public final Options mediaType(MediaType m) {
    		return mediaType(m.ordinal());
    	}
    	
    	private final native Options mediaType(int m) /*-{
			this.mediaType = m;
    		return this;
		}-*/;
    }
}

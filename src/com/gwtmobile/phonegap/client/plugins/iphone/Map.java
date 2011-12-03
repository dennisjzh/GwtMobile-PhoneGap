package com.gwtmobile.phonegap.client.plugins.iphone;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

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
public class Map {

	private static Callback callback;
	
    static {
        onMapCallback();
    }

	public static void setMapEventCallback(Callback callback) {
		Map.callback = callback;
	}
	
    public static native void show()/*-{
        $wnd.plugins.mapKit.showMap();
    }-*/;

    public static native void hide()/*-{
	    $wnd.plugins.mapKit.hideMap();
	}-*/;

	public static void addMapPins(List<Pin> pins){
	    @SuppressWarnings("unchecked")
		JsArray<JavaScriptObject> jsPins = (JsArray<JavaScriptObject>) JsArray.createArray();
        for(Pin pin : pins){
            jsPins.push(pin);
        }
        addMapPinsNative(jsPins);
    }

    private static native void addMapPinsNative(JavaScriptObject pins)/*-{
        $wnd.plugins.mapKit.addMapPins(pins);
    }-*/;

    public static native Void zoomToFitMapAnnotations()/*-{
        $wnd.plugins.mapKit.zoomToFitMapAnnotations();
    }-*/;

    public static native void clearMapPinsNative()/*-{
        $wnd.plugins.mapKit.clearMapPins();
    }-*/;

    public static native void setMapData(Options options)/*-{
        map.setMapData(options);
    }-*/;

    private static native void onMapCallback() /*-{
		//FIXME: pinIndex is string?
        $wnd.plugins.mapKit.onMapCallback = function(v){
            @com.gwtmobile.phonegap.client.plugins.iphone.Map::onMapClicked(Ljava/lang/String;)(v);
        }
    }-*/;

    private static void onMapClicked(String pinIndex) {
    	if (callback != null) {
    		callback.onMapClicked(pinIndex);
    	}
    }

	public interface Callback {
		void onMapClicked(String pinIndex);
	}
	

    public static class Pin extends JavaScriptObject {

    	public static Pin newInstance() {
            return (Pin) JavaScriptObject.createObject();
    	}
    	
    	protected Pin() {};
    	
        public native Pin latitude(double latitude)/*-{
            this.lat = latitude;
            return this;
        }-*/;

         public native double getLatitude()/*-{
            return this.lat;
        }-*/;

        public native Pin longitude(double longitude)/*-{
            this.lon = longitude;
            return this;
        }-*/;

        public native double getLongitude()/*-{
            return this.lon;
        }-*/;

        public native Pin title(String t)/*-{
            this.title = t;
            return this;
        }-*/;

        public native Pin subTitle(String t)/*-{
            this.subTitle = t;
            return this;
        }-*/;

        public native Pin pinColor(String color)/*-{
            this.pinColor = color;
            return this;
        }-*/;

        public native Pin index(int i)/*-{
            this.index = i;
            return this;
        }-*/;

        public native Pin selected(int s)/*-{
            this.selected = s;
            return this;
        }-*/;

        public native Pin image(String url)/*-{
            this.imageURL = url;
            return this;
        }-*/;
    }

    public static class Options extends JavaScriptObject {

    	public static Options newInstance() {
    		return (Options) JavaScriptObject.createObject();
    	}
    	
    	protected Options() {};
    	
        public native Options latitude(double latitude)/*-{
            this.lat = latitude;
            return this;
        }-*/;

        public native Options longitude(double longitude)/*-{
            this.lon = longitude;
            return this;
        }-*/;

        public native Options height(double h)/*-{
            this.height = h;
            return this;
        }-*/;

        public native Options diameter(double d)/*-{
            this.diameter = d;
            return this;
        }-*/;

        public native Options offsetTop(double o)/*-{
            this.offsetTop = o;
            return this;
        }-*/;

    }
}

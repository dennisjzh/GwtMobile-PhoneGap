package com.gwtmobile.phonegap.client.plugins.mapkitplug;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/11/11
 * Time: 12:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class Map {

    private JavaScriptObject mapKit;
    private EventBus handlerManager = new SimpleEventBus();

    public Map(){
        mapKit = getMapKit();
        onMapCallback(this);
    }

    public void show(){
        onMapCallback(this);
        showNative(mapKit);
    }

    public void hide(){
        hideNative(mapKit);
    }

    private native void hideNative(JavaScriptObject map)/*-{
        map.hideMap();
    }-*/;

    private native void showNative(JavaScriptObject map)/*-{
        map.showMap();
    }-*/;

    public void addMapPins(List<Pin> pins){
        JsArray<JavaScriptObject> jsPins = (JsArray<JavaScriptObject>) JsArray.createArray();
        for(Pin pin : pins){
            jsPins.push(pin.getPin());
        }
        addMapPinsNative(mapKit, jsPins);
    }

    private native void addMapPinsNative(JavaScriptObject map, JavaScriptObject pins)/*-{
        map.addMapPins(pins);
    }-*/;

    public void zoomToFitMapAnnotations(){
        zoomToFitMapAnnotations(mapKit);
    }

    private native Void zoomToFitMapAnnotations(JavaScriptObject map)/*-{
        map.zoomToFitMapAnnotations();
    }-*/;

    public void clearMapPins(){
        clearMapPinsNative(mapKit);
    }

    private native void clearMapPinsNative(JavaScriptObject map)/*-{
        map.clearMapPins();
    }-*/;

    public void setMapData(Options options){
        setMapData(mapKit, options.getOptions());
    }

    private native void setMapData(JavaScriptObject map, JavaScriptObject options)/*-{
        map.setMapData(options)
    }-*/;

    private native JavaScriptObject getMapKit()/*-{
        return $wnd.plugins.mapKit;
    }-*/;

    private native void onMapCallback(Map map)/*-{
        var instance = map;
        $wnd.plugins.mapKit.onMapCallback = function(v){
            instance.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map::onMapClicked(Ljava/lang/String;)(v);
        }
    }-*/;

    private void onMapClicked(String var) {
        handlerManager.fireEvent(new MapClickedEvent(var));
    }

    public HandlerRegistration addPinClickedHandler(MapClickedEventHandler handler){
        return handlerManager.addHandler(MapClickedEvent.getType(), handler);
    }


    public static class Pin {

        private Pin self = this;
        private JavaScriptObject pin = JavaScriptObject.createObject();

        public native Pin latitude(double latitude)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.lat = latitude;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

         public native double getLatitude()/*-{
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.lat;
        }-*/;

        public native Pin longitude(double longitude)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.lon = longitude;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

        public native double getLongitude()/*-{
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.lon;
        }-*/;

        public native Pin title(String t)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.title = t;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

        public native Pin subTitle(String t)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.subTitle = t;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

        public native Pin pinColor(String color)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.pinColor = color;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

        public native Pin index(int i)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.index = i;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

        public native Pin selected(int s)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.selected = s;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

        public native Pin image(String url)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::pin.imageURL = url;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Pin::self;
        }-*/;

        private JavaScriptObject getPin() {
            return pin;
        }

    }

    public static class Options {

        private Options self = this;
        private JavaScriptObject options = JavaScriptObject.createObject();

        public native Options latitude(double latitude)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::options.lat = latitude;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::self;
        }-*/;

        public native Options longitude(double longitude)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::options.lon = longitude;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::self;
        }-*/;

        public native Options height(double h)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::options.height = h;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::self;
        }-*/;

        public native Options diameter(double d)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::options.diameter = d;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::self;
        }-*/;

        public native Options offsetTop(double o)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::options.offsetTop = o;
            return this.@com.gwtmobile.phonegap.client.plugins.mapkitplug.Map.Options::self;
        }-*/;

        private JavaScriptObject getOptions() {
            return options;
        }

    }
}

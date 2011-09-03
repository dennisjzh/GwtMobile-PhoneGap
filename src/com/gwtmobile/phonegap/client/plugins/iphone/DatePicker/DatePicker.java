package com.gwtmobile.phonegap.client.plugins.iphone.DatePicker;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/18/11
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatePicker {

    private JavaScriptObject datePicker;
    private EventBus handlerManager = new SimpleEventBus();

    public DatePicker(){
        datePicker = getDatePickerNative();
    }

    private native JavaScriptObject getDatePickerNative()/*-{
        return $wnd.plugins.datePicker;
    }-*/;

    private native void showNative(JavaScriptObject datePicker, JavaScriptObject options)/*-{
        var instance = this;
        var callBack = function(date){
            instance.@com.gwtmobile.phonegap.client.plugins.iphone.DatePicker.DatePicker::onDateSelected(Ljava/lang/String;)(date)
        };

        datePicker.show(options, callBack);
    }-*/;

    public void show(Options options){
        showNative(datePicker, options.getOptions());
    }

    private void onDateSelected(String date){
        handlerManager.fireEvent(new DateSelectedEvent(date));
    }

    public HandlerRegistration addHandler(DateSelectedEventHandler handler){
        return handlerManager.addHandler(DateSelectedEvent.getType(), handler);
    }



    public static class Options {

        private Options self = this;
        private JavaScriptObject options = JavaScriptObject.createObject();

        public native Options date(String d)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.iphone.DatePicker.DatePicker.Options::options.date = new Date(d);
            return this.@com.gwtmobile.phonegap.client.plugins.iphone.DatePicker.DatePicker.Options::self;
        }-*/;

        public native Options mode(String m)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.iphone.DatePicker.DatePicker.Options::options.mode = m;
            return this.@com.gwtmobile.phonegap.client.plugins.iphone.DatePicker.DatePicker.Options::self;
        }-*/;

        private JavaScriptObject getOptions() {
            return options;
        }
    }


}

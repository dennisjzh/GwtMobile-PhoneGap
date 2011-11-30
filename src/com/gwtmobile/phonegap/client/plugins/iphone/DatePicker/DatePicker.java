package com.gwtmobile.phonegap.client.plugins.iphone.DatePicker;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

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
            this.@com.gwtmobile.phonegap.client.plugins.iphone.DatePicker.DatePicker.Options::options.date = d;
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

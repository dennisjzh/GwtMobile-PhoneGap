package com.gwtmobile.phonegap.client.plugins.iphone;

import com.google.gwt.core.client.JavaScriptObject;

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

    public static native void show(Options options, Callback callback)/*-{
        var instance = this;
        var callBack = function(date){
            callback.@com.gwtmobile.phonegap.client.plugins.iphone.DatePicker.Callback::onDateSelected(Ljava/lang/String;)(date)
        };

        $wnd.plugins.datePicker.show(options, callBack);
    }-*/;

    public interface Callback {
    	//FIXME: Date type?
    	void onDateSelected(String date);
    }
    
    public static class Options extends JavaScriptObject {

    	protected Options() {};
    	
    	public static Options newInstance() {
    		return (Options) JavaScriptObject.createObject();
    	}
    	
        public native Options date(String d)/*-{
            this.date = d;
            return this;
        }-*/;

        public native Options mode(String m)/*-{
            this.mode = m;
            return this;
        }-*/;
    }
}

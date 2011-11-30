package com.gwtmobile.phonegap.client.plugins.iphone.DatePicker;

import com.google.gwt.event.shared.GwtEvent;

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
public class DateSelectedEvent extends GwtEvent<DateSelectedEventHandler> {

    private static final Type<DateSelectedEventHandler> TYPE = new Type<DateSelectedEventHandler>();
    private String date;

    public DateSelectedEvent(String date){
        this.date = date;
    }

    @Override
    public Type<DateSelectedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DateSelectedEventHandler handler) {
        handler.onDateSelected(date);
    }

    public static Type<DateSelectedEventHandler> getType(){
        return TYPE;
    }
}

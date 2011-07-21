package com.gwtmobile.phonegap.client.plugins.iphone.DatePicker;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/19/11
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
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

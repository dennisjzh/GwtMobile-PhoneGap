package com.gwtmobile.phonegap.client.plugins.iphone.DatePicker;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/19/11
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DateSelectedEventHandler extends EventHandler {
    void onDateSelected(String date);
}

package com.gwtmobile.phonegap.client.plugins.mapkitplug;


import com.google.gwt.event.shared.EventHandler;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/11/11
 * Time: 2:22 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MapClickedEventHandler extends EventHandler {
    void onMapClicked(MapClickedEvent event);
}

package com.gwtmobile.phonegap.client.plugins.mapkitplug;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/11/11
 * Time: 2:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class MapClickedEvent extends GwtEvent<MapClickedEventHandler> {

	private static final Type<MapClickedEventHandler> TYPE = new Type<MapClickedEventHandler>();
    private String pinIndex;

    public MapClickedEvent(String pinIndex){
        this.pinIndex = pinIndex;
    }

    public static Type<MapClickedEventHandler> getType() {
		return TYPE;
	}

    @Override
    public Type<MapClickedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(MapClickedEventHandler handler) {
        handler.onMapClicked(this);
    }

    public String getPinIndex() {
        return pinIndex;
    }
}

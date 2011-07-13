package com.gwtmobile.phonegap.client.plugins.nativecontrols;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/9/11
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class TabBarItemSelectedEvent extends GwtEvent<TabBarItemSelectedEventHandler> {

    private String id;
	private static final Type<TabBarItemSelectedEventHandler> TYPE = new Type<TabBarItemSelectedEventHandler>();

    public TabBarItemSelectedEvent(String id){
        this.id = id;
    }

	public static Type<TabBarItemSelectedEventHandler> getType() {
		return TYPE;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<TabBarItemSelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

    @Override
    protected void dispatch(TabBarItemSelectedEventHandler handler) {
        handler.onSelect(this);
    }

    public String getId() {
        return id;
    }
}

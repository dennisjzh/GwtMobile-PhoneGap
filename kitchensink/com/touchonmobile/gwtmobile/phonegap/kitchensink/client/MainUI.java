package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainUI extends Composite {

	private static MainUIUiBinder uiBinder = GWT.create(MainUIUiBinder.class);

	interface MainUIUiBinder extends UiBinder<Widget, MainUI> {
	}

	public MainUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}

    @UiHandler("accelerometer")
    public void handleAccelerometerClick(ClickEvent e) {
    	goTo(new AccelerometerUi());
    }   

    @UiHandler("compass")
    public void handleCompassClick(ClickEvent e) {
    	goTo(new CompassUi());
    }   

    @UiHandler("geolocation")
    public void handleGeolocationClick(ClickEvent e) {
    	goTo(new GeolocationUi());
    }   

    @UiHandler("notification")
    public void handleNotificationClick(ClickEvent e) {
    	goTo(new NotificationUI());
    }   

    @UiHandler("event")
    public void handleEventClick(ClickEvent e) {
    	goTo(new EventUI());
    }   

    private void goTo(Composite page) {
    	RootLayoutPanel.get().remove(this);
    	RootLayoutPanel.get().add(page);				
    }
}

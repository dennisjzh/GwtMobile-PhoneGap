package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.Notification;

public class MainUI extends Composite {

	private static MainUIUiBinder uiBinder = GWT.create(MainUIUiBinder.class);

	interface MainUIUiBinder extends UiBinder<Widget, MainUI> {
	}

	public MainUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}

    @UiHandler("accelerometer")
    public void handleAccelerometerClick(ClickEvent e) {
    	AccelerometerUi accelUi = new AccelerometerUi();
    	RootLayoutPanel.get().remove(this);
    	RootLayoutPanel.get().add(accelUi);				
    }   

    @UiHandler("notification")
    public void handleNotificationClick(ClickEvent e) {
    	NotificationUI notificationUi = new NotificationUI();
    	RootLayoutPanel.get().remove(this);
    	RootLayoutPanel.get().add(notificationUi);				
    }   

    @UiHandler("event")
    public void handleEventClick(ClickEvent e) {
    	EventUI eventUi = new EventUI();
    	RootLayoutPanel.get().remove(this);
    	RootLayoutPanel.get().add(eventUi);				
    }   

}

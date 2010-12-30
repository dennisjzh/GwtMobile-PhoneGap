package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.Notification;
import com.touchonmobile.gwtmobile.phonegap.client.Notification.Callback;
import com.touchonmobile.gwtmobile.phonegap.client.Notification.ConfirmCallback;

public class NotificationUI extends Composite {

	private static NotificationUiBinder uiBinder = GWT
			.create(NotificationUiBinder.class);

	interface NotificationUiBinder extends UiBinder<Widget, NotificationUI> {
	}

	@UiField TextBox text;
	
	public NotificationUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("alert")
    public void handleAlertClick(ClickEvent e) {
    	Notification.alert("This is an alert message", new Callback() {
			@Override
			public void onComplete() {
				Window.alert("Callback from alert!");
			}
		}, "Alert", "Okey-Dokey");
    	
    }   

    @UiHandler("confirm")
    public void handleConfirmClick(ClickEvent e) {
    	Notification.confirm("This is a confirmation message", new ConfirmCallback() {
			@Override
			public void onComplete(int result) {
				Window.alert("You selected " + (result == 1 ? "Yes" : "No"));
			}
		}, "Confirm", "Yes,No");
    }   

    @UiHandler("beep")
    public void handleBeepClick(ClickEvent e) {
    	Notification.beep(1);
    	Window.alert("heard the beep?");
    }   

    @UiHandler("vibrate")
    public void handleVibrateClick(ClickEvent e) {
    	Notification.vibrate(100);
    	Window.alert("felt the vibration?");
    }   

    @UiHandler("blink")
    public void handleBlinkClick(ClickEvent e) {
    	Notification.blink(3, "red");
    	Window.alert("saw the light blinking?");
    }   

    @UiHandler("activity")
    public void handleActivityClick(ClickEvent e) {
    	Notification.activityStart();
    	new Timer(){
			@Override
			public void run() {
				Notification.activityStop();
			}
		}.schedule(3000);
    }   

    @UiHandler("progress")
    public void handleProgressClick(ClickEvent e) {
    	Notification.progressStart("Downloading", "Please be patient...");
    	new Timer(){
    		int value = 0;
			@Override
			public void run() {
				Notification.progressValue(value++);
				if (value > 100) {
					Notification.progressStop();
					this.cancel();
				}
			}
		}.scheduleRepeating(20);
    }       
}

package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.Accelerometer;
import com.touchonmobile.gwtmobile.phonegap.client.Accelerometer.Acceleration;
import com.touchonmobile.gwtmobile.phonegap.client.Accelerometer.Callback;
import com.touchonmobile.gwtmobile.phonegap.client.Accelerometer.Options;

public class AccelerometerUi extends Composite {

	@UiField TextArea text;
	String watchId;

	private static AccelerometerUiUiBinder uiBinder = GWT
			.create(AccelerometerUiUiBinder.class);

	interface AccelerometerUiUiBinder extends UiBinder<Widget, AccelerometerUi> {
	}

	public AccelerometerUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("current")
    public void handleCurrentClick(ClickEvent e) {
		Accelerometer.getCurrentAcceleration(new Callback() {			
			@Override
			public void onSuccess(Acceleration accel) {
				text.setText("Current Acceleration\nX: " + accel.getX() + "\nY: " + accel.getY() + "\nZ: " + accel.getZ());				
			}			
			@Override
			public void onError() {
				text.setText("Error");
			}
		});
	}

	@UiHandler("watch")
    public void handleWatchClick(ClickEvent e) {
		watchId = Accelerometer.watchAcceleration(new Callback() {			
			@Override
			public void onSuccess(Acceleration accel) {
				text.setText("Watch Acceleration\nX: " + accel.getX() + "\nY: " + accel.getY() + "\nZ: " + accel.getZ());				
			}			
			@Override
			public void onError() {
				text.setText("Error");
			}
		}, new Options().frequency(100));
	}

	@UiHandler("clear")
    public void handleClearClick(ClickEvent e) {
		Accelerometer.clearWatch(watchId);
		text.setText("");
	}
}

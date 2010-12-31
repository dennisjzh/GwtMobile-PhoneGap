/* Copyright (c) 2010 Zhihua (Dennis) Jiang
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

package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.Geolocation;
import com.touchonmobile.gwtmobile.phonegap.client.Geolocation.Callback;
import com.touchonmobile.gwtmobile.phonegap.client.Geolocation.Options;
import com.touchonmobile.gwtmobile.phonegap.client.Geolocation.Position;
import com.touchonmobile.gwtmobile.phonegap.client.Geolocation.PositionError;

public class GeolocationUi extends Composite {

	@UiField TextArea text;
	String watchId;

	private static GeolocationUiUiBinder uiBinder = GWT
			.create(GeolocationUiUiBinder.class);

	interface GeolocationUiUiBinder extends UiBinder<Widget, GeolocationUi> {
	}

	public GeolocationUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("current")
    public void handleCurrentClick(ClickEvent e) {
		Geolocation.getCurrentPosition(new Callback() {			
			@Override
			public void onSuccess(Position position) {
				text.setText("Current Position\nLatitude: " + position.getCoords().getLatitude() + "\n" + 
						"Longitude: " + position.getCoords().getLongitude() + "\n" +
						"Altitude: " + position.getCoords().getAltitude() + "\n" +
						"Accuracy: " + position.getCoords().getAccuracy() + "\n" +
						"Altitude Accuracy: " + position.getCoords().getAltitudeAccuracy() + "\n" +
						"Heading: " + position.getCoords().getHeading() + "\n" +
						"Speed: " + position.getCoords().getSpeed() + "\n" +
						"Timestamp: " + position.getTimestamp() + "\n"
						);				
			}			
			@Override
			public void onError(PositionError error) {
				text.setText("Error\ncode:" + error.getCode() + "\nmessage: " + error.getMessage());
			}
		});
	}

	@UiHandler("watch")
    public void handleWatchClick(ClickEvent e) {
		watchId = Geolocation.watchPosition(new Callback() {			
			@Override
			public void onSuccess(Position position) {
				text.setText("Watch Position\nLatitude: " + position.getCoords().getLatitude() + "\n" + 
						"Longitude: " + position.getCoords().getLongitude() + "\n" +
						"Altitude: " + position.getCoords().getAltitude() + "\n" +
						"Accuracy: " + position.getCoords().getAccuracy() + "\n" +
						"Altitude Accuracy: " + position.getCoords().getAltitudeAccuracy() + "\n" +
						"Heading: " + position.getCoords().getHeading() + "\n" +
						"Speed: " + position.getCoords().getSpeed() + "\n" +
						"Timestamp: " + position.getTimestamp() + "\n"
						);				
			}			
			@Override
			public void onError(PositionError error) {
				text.setText("Error\ncode:" + error.getCode() + "\nmessage: " + error.getMessage());
			}
		}, new Options().frequency(100).enableHighAccuracy(true).timeout(1000).maximumAge(1000));
	}

	@UiHandler("clear")
    public void handleClearClick(ClickEvent e) {
		Geolocation.clearWatch(watchId);
		text.setText("");
	}
}

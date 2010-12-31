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
import com.touchonmobile.gwtmobile.phonegap.client.Compass;
import com.touchonmobile.gwtmobile.phonegap.client.Compass.Callback;
import com.touchonmobile.gwtmobile.phonegap.client.Compass.Options;

public class CompassUi extends Composite {

	@UiField TextArea text;
	String watchId;

	private static CompassUiUiBinder uiBinder = GWT
			.create(CompassUiUiBinder.class);

	interface CompassUiUiBinder extends UiBinder<Widget, CompassUi> {
	}

	public CompassUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("current")
    public void handleCurrentClick(ClickEvent e) {
		Compass.getCurrentHeading(new Callback() {			
			@Override
			public void onSuccess(float heading) {
				text.setText("Current Heading\n: " + heading);				
			}			
			@Override
			public void onError() {
				text.setText("Error");
			}
		});
	}

	@UiHandler("watch")
    public void handleWatchClick(ClickEvent e) {
		watchId = Compass.watchHeading(new Callback() {			
			@Override
			public void onSuccess(float heading) {
				text.setText("Watch Heading\n: " + heading);				
			}			
			@Override
			public void onError() {
				text.setText("Error");
			}
		}, new Options().frequency(100));
	}

	@UiHandler("clear")
    public void handleClearClick(ClickEvent e) {
		Compass.clearWatch(watchId);
		text.setText("");
	}
}

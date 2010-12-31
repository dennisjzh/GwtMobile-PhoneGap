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

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.PhoneGap;
import com.touchonmobile.gwtmobile.phonegap.client.PhoneGap.Callback;

public class EventUI extends Composite {

	private static EventUIUiBinder uiBinder = GWT.create(EventUIUiBinder.class);
	
	@UiField TextArea text;

	interface EventUIUiBinder extends UiBinder<Widget, EventUI> {
	}

	public EventUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		
		PhoneGap.onDeviceReady(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onDeviceReady\n" + text.getText());
			}
		});
		
		PhoneGap.onPause(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onPause\n" + text.getText());
			}
		});

		PhoneGap.onResume(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onResume\n" + text.getText());
			}
		});
	}

}

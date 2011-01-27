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

package com.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.phonegap.client.Device;
import com.gwtmobile.ui.client.page.Page;

public class DeviceUi extends Page {

	private static DeviceUiUiBinder uiBinder = GWT.create(DeviceUiUiBinder.class);
	
	@UiField TextArea text;

	interface DeviceUiUiBinder extends UiBinder<Widget, DeviceUi> {
	}

	public DeviceUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		
		text.setText("Device Name: " + Device.getName());
		text.setText(text.getText() + "\nDevice PhongGap: " + Device.getPhoneGap());
		text.setText(text.getText() + "\nDevice Platform: " + Device.getPlatform());
		text.setText(text.getText() + "\nDevice UUID: " + Device.getUUID());
		text.setText(text.getText() + "\nDevice Version: " + Device.getVersion());
	}
}

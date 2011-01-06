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
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainUi extends Composite {

	private static MainUiUiBinder uiBinder = GWT.create(MainUiUiBinder.class);

	interface MainUiUiBinder extends UiBinder<Widget, MainUi> {
	}

	public MainUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

    @UiHandler("accelerometer")
    public void handleAccelerometerClick(ClickEvent e) {
    	goTo(new AccelerometerUi());
    }   

    @UiHandler("camera")
    public void handleCameraClick(ClickEvent e) {
    	goTo(new CameraUi());
    }   

    @UiHandler("compass")
    public void handleCompassClick(ClickEvent e) {
    	goTo(new CompassUi());
    }   

    @UiHandler("contacts")
    public void handleContactsClick(ClickEvent e) {
    	goTo(new ContactsUi());
    }   

    @UiHandler("device")
    public void handleDeviceClick(ClickEvent e) {
    	goTo(new DeviceUi());
    }   

    @UiHandler("file")
    public void handleFileClick(ClickEvent e) {
    	goTo(new FileUi());
    }   

    @UiHandler("geolocation")
    public void handleGeolocationClick(ClickEvent e) {
    	goTo(new GeolocationUi());
    }   

    @UiHandler("media")
    public void handleMediaClick(ClickEvent e) {
    	goTo(new MediaUi());
    }   

    @UiHandler("network")
    public void handleNetworkClick(ClickEvent e) {
    	goTo(new NetworkUi());
    }   

    @UiHandler("notification")
    public void handleNotificationClick(ClickEvent e) {
    	goTo(new NotificationUi());
    }   

    @UiHandler("event")
    public void handleEventClick(ClickEvent e) {
    	goTo(new EventUi());
    }   

    private void goTo(Composite page) {
    	RootLayoutPanel.get().remove(this);
    	RootLayoutPanel.get().add(page);				
    }
}

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
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.widgets.ListPanel;

public class MainUi extends Page {

	private static MainUiUiBinder uiBinder = GWT.create(MainUiUiBinder.class);
    @UiField
    ListPanel list;

    interface MainUiUiBinder extends UiBinder<Widget, MainUi> {
	}

	public MainUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

    @UiHandler("list")
	void onListSelectionChanged(SelectionChangedEvent e) {

    	switch (e.getSelection()) {
    	case 0:
    		goTo(new AccelerometerUi());
    		break;
    	case 1:
    		goTo(new CameraUi());
    		break;
    	case 2:
    		goTo(new CaptureUi());
    		break;
    	case 3:
    		goTo(new CompassUi());
    		break;
    	case 4:
    		goTo(new ContactsUi());
    		break;
    	case 5:
    		goTo(new DeviceUi());
    		break;
    	case 6:
    		goTo(new EventUi());
    		break;
    	case 7:
    		goTo(new FileMgrUi());
    		break;
    	case 8:
    		goTo(new GeolocationUi());
    		break;
    	case 9:
    		goTo(new MediaUi());
    		break;
    	case 10:
    		goTo(new NetworkUi());
    		break;
    	case 11:
    		goTo(new NotificationUi());
    		break;
    	case 12:
    		goTo(new PluginsUi());
    		break;
    	case 13:
    		goTo(new StorageUi());
    		break;
        case 14:
            goTo(new DatepickerUI());
            break;
        case 15:
            goTo(new NotificationExUI());
            break;
        case 16:
            goTo(new PromptUI());
            break;
        case 17:
            goTo(new TabBarUI());
            break;
    	}
    }

}

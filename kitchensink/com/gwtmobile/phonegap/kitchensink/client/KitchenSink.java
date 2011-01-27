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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.gwtmobile.ui.client.page.PageHistory;

public class KitchenSink implements EntryPoint {

	public static MainUi mainUi = new MainUi();
	
	@Override
	public void onModuleLoad() {
		setCSS();

//		PhoneGap.onDeviceReady(new Callback() {			
//			@Override
//			public void onEventFired() {
				RootLayoutPanel.get().add(mainUi);
		        PageHistory.add(mainUi);
//			}
//		});
		
	}

	private void setCSS() {
		String ratio = getDevicePixelRatio();
		if (ratio.equals("1.5")) {
	    	Document.get().getBody().setClassName("WVGA");
		}
		else if (ratio.equals("0.75")) {
	    	Document.get().getBody().setClassName("QVGA");
		}
		else {
	    	Document.get().getBody().setClassName("HVGA");
		}
	}
	
    private native String getDevicePixelRatio() /*-{
		return $wnd.devicePixelRatio + "";
	}-*/;

    public static native void Console(String msg) /*-{
		$wnd.console.log("gwtmobile:" + msg);
	}-*/;

    
}

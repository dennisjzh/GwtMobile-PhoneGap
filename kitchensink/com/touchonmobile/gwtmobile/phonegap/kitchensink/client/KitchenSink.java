package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.touchonmobile.gwtmobile.phonegap.client.PhoneGap;
import com.touchonmobile.gwtmobile.phonegap.client.PhoneGap.Callback;

public class KitchenSink implements EntryPoint {

	public static MainUI mainUi = new MainUI();
	
	@Override
	public void onModuleLoad() {
		setCSS();

		PhoneGap.onDeviceReady(new Callback() {			
			@Override
			public void onEventFired() {
				RootLayoutPanel.get().add(mainUi);				
			}
		});
		
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

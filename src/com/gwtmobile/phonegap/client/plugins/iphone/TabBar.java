package com.gwtmobile.phonegap.client.plugins.iphone;

import com.google.gwt.core.client.JavaScriptObject;

/* Copyright (c) 2011 Smithimage (Robert Wallström)
 *
 * author: Robert Wallström
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
public class TabBar {
	
	private static Callback callback;
	
    public static native void create() /*-{
	    $wnd.plugins.nativeControls.createTabBar();
	}-*/;

    public static void creatItem(String name, String label, String image){
    	creatItem(name, label, image, Options.newInstance());
	};

    public static native void creatItem(String name, String label, String image, Options options)/*-{
        $wnd.plugins.nativeControls.createTabBarItem(name, label, image, options);
    }-*/;

    public static void show(){
        show(Options.newInstance().position("bottom"));
    }

    public static native void show(Options options)/*-{
	    $wnd.plugins.nativeControls.showTabBar(options);
	}-*/;

    public static native void showItems(String itemName1, Options options)/*-{
	    $wnd.plugins.nativeControls.showTabBarItems(itemName1, options)
	}-*/;

    public static native void showItems(String itemName1, String itemName2, Options options)/*-{
	    $wnd.plugins.nativeControls.showTabBarItems(itemName1, itemName2, options)
	}-*/;

    public static native void showItems(String itemName1, String itemName2, String itemName3, Options options)/*-{
	    $wnd.plugins.nativeControls.showTabBarItems(itemName1, itemName2, itemName3, options)
	}-*/;

    public static native void showItems(String itemName1, String itemName2, String itemName3, String itemName4, Options options)/*-{
	    $wnd.plugins.nativeControls.showTabBarItems(itemName1, itemName2, itemName3, itemName4, options)
	}-*/;

    public static native void showItems(String itemName1, String itemName2, String itemName3, String itemName4, String itemName5, Options options)/*-{
	    $wnd.plugins.nativeControls.showTabBarItems(itemName1, itemName2, itemName3, itemName4, itemName5, options)
	}-*/;

    public static native void hide(boolean animate)/*-{
	    $wnd.plugins.nativeControls.hideTabBar(animate)
	}-*/;

    public static native void selectItem(String name)/*-{
    	$wnd.plugins.nativeControls.selectTabBarItem(name);
	}-*/;

    public static void setCallback(Callback callback) {
    	TabBar.callback = callback;
    }
    
    private static void onTabItemSelected(String id) {
    	if (callback != null) {
    		callback.onSelected(id);
    	}
    }

	public interface Callback {
		void onSelected(String id);
	}

    public static class Options extends JavaScriptObject {

    	public static Options newInstance() {
    		Options options = (Options) JavaScriptObject.createObject();
    		options.setOnSelectCallback();
    		return options;
    	}
    	
    	private Options() {};

        public native Options position(String p) /*-{
            this.position = p;
            return this;
        }-*/;

        public native Options height(int h)/*-{
            this.height = h;
            return this;
        }-*/;

        public native Options animate(boolean a)/*-{
            this.animate = a;
            return this;
        }-*/;

        private native void setOnSelectCallback()/*-{
            this.onSelect = function(id){
                    @com.gwtmobile.phonegap.client.plugins.iphone.TabBar::onTabItemSelected(Ljava/lang/String;)(id);
            };
        }-*/;

    }
}



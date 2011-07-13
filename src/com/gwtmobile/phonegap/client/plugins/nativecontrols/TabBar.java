package com.gwtmobile.phonegap.client.plugins.nativecontrols;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/9/11
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TabBar {

    private EventBus handlerManager = new SimpleEventBus();
    private JavaScriptObject nativeControls;

    public TabBar(){
        nativeControls = getNativeControls();
        createTabBar(nativeControls);
    }

    public void show(){
        show(new Options().position("bottom"));
    }

     public void show(Options options){
        showTabBarNative(nativeControls, options.getOptions());
    }

    public void showTabBarItems(String itemName1, Options options){
        showTabBarItemsNative(nativeControls, itemName1, options.getOptions());
    }

    private native void showTabBarItemsNative(JavaScriptObject controls, String itemName1, JavaScriptObject options)/*-{
        controls.showTabBarItems(itemName1, options)
    }-*/;

    public void showTabBarItems(String itemName1, String itemName2, Options options){
        showTabBarItemsNative(nativeControls, itemName1, itemName2, options.getOptions());
    }

    private native void showTabBarItemsNative(JavaScriptObject controls, String itemName1, String itemName2, JavaScriptObject options)/*-{
        controls.showTabBarItems(itemName1, itemName2, options)
    }-*/;

    public void showTabBarItems(String itemName1, String itemName2, String itemName3, Options options){
        showTabBarItemsNative(nativeControls, itemName1, itemName2, itemName3, options.getOptions());
    }

    private native void showTabBarItemsNative(JavaScriptObject controls, String itemName1, String itemName2,
                                              String itemName3, JavaScriptObject options)/*-{
        controls.showTabBarItems(itemName1, itemName2, itemName3, options)
    }-*/;

    public void showTabBarItems(String itemName1, String itemName2, String itemName3, String itemName4, Options options){
        showTabBarItemsNative(nativeControls, itemName1, itemName2, itemName3, itemName4, options.getOptions());
    }

    private native void showTabBarItemsNative(JavaScriptObject controls, String itemName1, String itemName2,
                                              String itemName3, String itemName4, JavaScriptObject options)/*-{
        controls.showTabBarItems(itemName1, itemName2, itemName3, itemName4, options)
    }-*/;

    public void showTabBarItems(String itemName1, String itemName2, String itemName3, String itemName4,
                                String itemName5, Options options){
        showTabBarItemsNative(nativeControls, itemName1, itemName2, itemName3, itemName4, itemName5, options.getOptions());
    }

    private native void showTabBarItemsNative(JavaScriptObject controls, String itemName1, String itemName2,
                                              String itemName3, String itemName4, String itemName5, JavaScriptObject options)/*-{
        controls.showTabBarItems(itemName1, itemName2, itemName3, itemName4, itemName5, options)
    }-*/;

    public void hide(boolean  animate){
        hideTabBarNative(nativeControls, animate);
    }

    public void createTabBarItem(String name, String label, String image, TabBarItemSelectedEventHandler handler){
        createTabBarItem(name, label, image, new Options().onSelect(this, name));
        addTabBarItemSelectedHandler(handler);
    }

    public void createTabBarItem(String name, String label, String image, Options options){
        createTabBarItemNative(nativeControls, name, label, image, options.getOptions());
    }

    private native void createTabBarItemNative(JavaScriptObject controls, String name, String label, String image, JavaScriptObject options)/*-{
        controls.createTabBarItem(name, label, image, options);
    }-*/;

    private native void hideTabBarNative(JavaScriptObject controls, boolean animate)/*-{
        return controls.hideTabBar(animate)
    }-*/;

    private native JavaScriptObject getNativeControls()/*-{
        return $wnd.plugins.nativeControls;
    }-*/;

    private native void createTabBar(JavaScriptObject controls)/*-{
        controls.createTabBar();
    }-*/;

    private native void showTabBarNative(JavaScriptObject controls, JavaScriptObject options)/*-{
        controls.showTabBar(options);
    }-*/;

    private native void selectTabBarItemNative(JavaScriptObject controls, String name)/*-{
        controls.selectTabBarItem(name);
    }-*/;

    public void selectTabBarItem(String name){
        selectTabBarItemNative(nativeControls, name);
    }

    private void onTabItemSelected(String id) {
        handlerManager.fireEvent(new TabBarItemSelectedEvent(id));
    }

    public HandlerRegistration addTabBarItemSelectedHandler(TabBarItemSelectedEventHandler handler){
        return handlerManager.addHandler(TabBarItemSelectedEvent.getType(), handler);
    }

    public static class Options {

        private Options self = this;
        private JavaScriptObject options = JavaScriptObject.createObject();

        public native Options position(String p) /*-{
            this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::options.position = p;
            return this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::self;
        }-*/;

        public native Options height(int h)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::options.height = h;
            return this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::self;
        }-*/;

        public native Options animate(boolean a)/*-{
            this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::options.animate = a;
            return this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::self;
        }-*/;

        public native Options onSelect(TabBar tabBar, String id)/*-{
            var instance = tabBar;

            this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::options.onSelect = function(id){
                    instance.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar::onTabItemSelected(Ljava/lang/String;)(id);
            };

            return this.@com.gwtmobile.phonegap.client.plugins.nativecontrols.TabBar.Options::self;
        }-*/;


        private JavaScriptObject getOptions() {
            return options;
        }

    }
}



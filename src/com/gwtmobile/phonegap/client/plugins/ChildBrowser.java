/*
 * Copyright (c) 2011 Zhihua (Dennis) Jiang
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

package com.gwtmobile.phonegap.client.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

public class ChildBrowser {

    private EventBus handlerManager = new SimpleEventBus();
    private boolean initialized;
    private JavaScriptObject cb;

    public void initialize() {
        cb = install();
        initialized = true;
    }

    private native JavaScriptObject install() /*-{
        var instance = this;
        var cb = $wnd.ChildBrowser.install();

        cb.onLocationChange = function(loc) {
            instance.@com.gwtmobile.phonegap.client.plugins.ChildBrowser::onLocationChange(Ljava/lang/String;)(loc);
        };
        cb.onClose = function() {
            instance.@com.gwtmobile.phonegap.client.plugins.ChildBrowser::onClose()();
        };
        cb.onOpenExternal = function() {
            instance.@com.gwtmobile.phonegap.client.plugins.ChildBrowser::onOpenExternal()();
        };

        return cb;

    }-*/;

    public void showWebPage(String url) {
        if (!initialized) {
            throw new IllegalStateException("you have to initialize Childbrowser before using it");
        }

        showWebPageNative(cb, url);

    }

    private native void showWebPageNative(JavaScriptObject cb, String url)/*-{
        cb.showWebPage(url);
    }-*/;

    public void close() {
        if (!initialized) {
            throw new IllegalStateException("you have to initialize Childbrowser before using it");
        }

        closeNative(cb);
    }

    private native void closeNative(JavaScriptObject cb)/*-{
        cb.close();
    }-*/;


    public HandlerRegistration addLocationChangeHandler(ChildBrowserLocationChangedHandler handler) {
        return handlerManager.addHandler(ChildBrowserLocationChangedEvent.getType(), handler);
    }

    public HandlerRegistration addCloseHandler(ChildBrowserCloseHandler handler) {
        return handlerManager.addHandler(ChildBrowserCloseEvent.getType(), handler);
    }

    public HandlerRegistration addOpenExternalHandler(ChildBrowserOpenExternalHandler handler) {
        return handlerManager.addHandler(ChildBrowserOpenExternalEvent.getType(), handler);
    }

    private void onClose() {
        handlerManager.fireEvent(new ChildBrowserCloseEvent());
    }

    private void onOpenExternal() {
        handlerManager.fireEvent(new ChildBrowserOpenExternalEvent());
    }

    private void onLocationChange(String url) {
        handlerManager.fireEvent(new ChildBrowserLocationChangedEvent(url));
    }


}

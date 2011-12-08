package com.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.gwtmobile.phonegap.client.plugins.iphone.TabBar;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.widgets.ListPanel;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 12/8/11
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TabBarUI extends Page  {
    interface TabBarUIUiBinder extends UiBinder<HTMLPanel, TabBarUI> {
    }

    private static TabBarUIUiBinder ourUiBinder = GWT.create(TabBarUIUiBinder.class);
    @UiField
    HTML text;
    @UiField
    ListPanel list;

    public TabBarUI() {
        initWidget(ourUiBinder.createAndBindUi(this));
        TabBar.setCallback(new TabBar.Callback() {
            public void onSelected(String id) {
                text.setHTML("You selected tab with id: " + id);
            }
        });

        TabBar.create();
        TabBar.creatItem("Tab1", "Tab1", "Favorites");
        TabBar.creatItem("Tab2", "Tab2", "Featured");
        TabBar.creatItem("Tab3", "Tab3", "History");

    }

    @UiHandler("list")
    void onListSelectionChanged(SelectionChangedEvent e) {
        switch (e.getSelection()) {
            case 0:
                TabBar.show();
                TabBar.showItems("Tab1", "Tab2", "Tab3", TabBar.Options.newInstance().animate(true));
                break;
            case 1:
                TabBar.hide(true);
                Window.alert("Passed hide");
                break;
        }
    }
}
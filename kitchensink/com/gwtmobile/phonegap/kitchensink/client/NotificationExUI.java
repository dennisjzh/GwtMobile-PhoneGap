package com.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.gwtmobile.phonegap.client.plugins.iphone.NotificationEx;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.widgets.ListPanel;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 12/5/11
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationExUI  extends Page {
    interface NotificationExUIUiBinder extends UiBinder<HTMLPanel, NotificationExUI> {
    }

    private static NotificationExUIUiBinder ourUiBinder = GWT.create(NotificationExUIUiBinder.class);
    @UiField
    ListPanel list;

    public NotificationExUI() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("list")
    void onListSelectionChanged(SelectionChangedEvent e) {
        switch (e.getSelection()) {
            case 0:
                NotificationEx.loadingStart();
                Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand(){
                    public boolean execute() {
                        NotificationEx.loadingStop();
                        return false;
                    }
                }, 5000);
                break;
            case 1:
                NotificationEx.activityStart();
                Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand(){

                    public boolean execute() {
                        NotificationEx.activityStop();
                        return false;
                    }
                }, 5000);
                break;
        }
    }
}
package com.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.gwtmobile.phonegap.client.plugins.iphone.Prompt;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.widgets.ListPanel;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 12/8/11
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class PromptUI extends Page {
    interface PromptUIUiBinder extends UiBinder<HTMLPanel, PromptUI> {
    }

    private static PromptUIUiBinder ourUiBinder = GWT.create(PromptUIUiBinder.class);
    @UiField
    ListPanel list;
    @UiField
    HTML text;

    public PromptUI() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

     @UiHandler("list")
    void onListSelectionChanged(SelectionChangedEvent e) {
        switch (e.getSelection()) {
            case 0:
                Prompt.show("Example title", "Ok button", "Cancel button", new Prompt.Callback() {
                    public void onOk(String userInput) {
                        text.setHTML("You selected OK and entered:" + userInput);
                    }

                    public void onCancel() {
                        text.setHTML("You selected CANCEL");
                    }
                });
                break;
        }
    }


}
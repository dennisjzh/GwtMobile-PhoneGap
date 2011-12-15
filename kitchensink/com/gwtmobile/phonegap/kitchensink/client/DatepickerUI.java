package com.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.gwtmobile.phonegap.client.plugins.iphone.DatePicker;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.widgets.ListPanel;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 12/2/11
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatepickerUI extends Page {

    interface DatepickerUIUiBinder extends UiBinder<HTMLPanel, DatepickerUI> {
    }

    private static DatepickerUIUiBinder ourUiBinder = GWT.create(DatepickerUIUiBinder.class);
    @UiField
    ListPanel list;
    @UiField
    HTML text;


    private DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");


    public DatepickerUI() {
       initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("list")
    void onListSelectionChanged(SelectionChangedEvent e) {
        switch (e.getSelection()) {
            case 0:
                DatePicker.show(DatePicker.Options.newInstance().date(dateTimeFormat.format(new Date())),
                        new DatePicker.Callback() {
                            public void onDateSelected(String sDate) {
                                Date date = new Date(Long.parseLong(DatePicker.webDateToMilliSec(sDate)));
                                text.setHTML("Selected date :" + dateTimeFormat.format(date));
                            }
                        });
                break;
        }
    }
}
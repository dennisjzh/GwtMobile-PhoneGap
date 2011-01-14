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
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.phonegap.client.Contacts;
import com.gwtmobile.phonegap.client.Contacts.Callback;
import com.gwtmobile.phonegap.client.Contacts.Contact;
import com.gwtmobile.phonegap.client.Contacts.ContactError;
import com.gwtmobile.phonegap.client.Contacts.ContactFields;
import com.gwtmobile.phonegap.client.Contacts.ContactFindCallback;
import com.gwtmobile.phonegap.client.Contacts.ContactFindOptions;
import com.gwtmobile.phonegap.client.Contacts.ContactName;

public class ContactsUi extends Composite {

	@UiField TextArea text;
	String watchId;

	private static ContactsUiUiBinder uiBinder = GWT
			.create(ContactsUiUiBinder.class);

	interface ContactsUiUiBinder extends UiBinder<Widget, ContactsUi> {
	}

	public ContactsUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("create")
    public void handleCreateClick(ClickEvent e) {
		Contact contact = Contacts.newInstance();
		contact.setDisplayName("Plumber");
		contact.setNickname("Plumber");
		
		ContactName name = ContactName.newInstance();
		name.setGivenName("Jane");
		name.setFamilyName("Doe");
		contact.setName(name);
		
		contact.save(new Callback() {			
			@Override
			public void onSuccess() {
				text.setText("Contact created.");
			}			
			@Override
			public void onError(ContactError error) {
				text.setText("Contact creation failed.\n" + error);
			}
		});
	}

	@UiHandler("find")
    public void handleFindClick(ClickEvent e) {
		try {
			
			Contacts.find(new ContactFields("nickname"), new ContactFindCallback() {
				@Override
				public void onSuccess(JsArray<Contact> contacts) {
					text.setText("Find contact " + contacts.length());
					if (contacts.length() > 0) {
						text.setText(text.getText() + "\nNickname: " + contacts.get(0).getNickname());
					}
				}
				@Override
				public void onError(ContactError error) {
					text.setText("Contact find failed.\n" + error);
				}
			}, new ContactFindOptions().filter("Plumber"));
		
		} catch (Exception exception) {
			
			text.setText(exception.getCause().toString());
			
		}
		
	}


}

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

package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class Header extends Composite {

	private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);
	
	@UiField Label title;

	interface HeaderUiBinder extends UiBinder<Widget, Header> {
	}

	public Header() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("back")
    public void handleBackClick(ClickEvent e) {
		RootLayoutPanel.get().remove(this.getParent().getParent());
		RootLayoutPanel.get().add(KitchenSink.mainUi);
    }
	
	public void setTitle(String title) {
		this.title.setText(title);
	}
}

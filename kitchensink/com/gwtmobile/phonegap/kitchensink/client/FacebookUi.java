/* Copyright (c) 2011 Zhihua (Dennis) Jiang
 * 
 * author: Daniel Tizón
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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.phonegap.client.plugins.Facebook;
import com.gwtmobile.phonegap.client.plugins.Facebook.Callback;
import com.gwtmobile.phonegap.client.plugins.Facebook.Params;
import com.gwtmobile.phonegap.client.plugins.Facebook.Response;
import com.gwtmobile.phonegap.client.plugins.Facebook.Session;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;

public class FacebookUi extends Page {

	private static boolean initialized = false;
	@UiField
	HTML text;

	private static FacebookUiUiBinder uiBinder = GWT
			.create(FacebookUiUiBinder.class);

	interface FacebookUiUiBinder extends UiBinder<Widget, FacebookUi> {
	}

	public FacebookUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("list")
	void onListSelectionChanged(SelectionChangedEvent e) {
		switch (e.getSelection()) {
		case 0:
			init();
			break;
		case 1:
			login();
			break;
		case 2:
			getLoginStatus();
			break;
		case 3:
			post();
			break;
		case 4:
			logout();
			break;
		}
	}

	private void init() {
		if (!initialized) {
			Facebook.init("240209569368100");
			initialized = true;
			text.setHTML("Facebook plugin initialized.");
		}
		else {
			text.setHTML("Already initialized.");
		}
	}

	public void login() {
		if (!initialized) {
			text.setHTML("Facebook plugin not initialized.");
			return;
		}
		Facebook.login(new Callback() {
			@Override
			public void onSuccess(Response response) {
				text.setHTML("Response from login:<br/>" +
						"Status:" + response.getStatus() + "<br/>" + 
						((response.getSession() == null) ? "" :
						("AccessToken:" + response.getSession().getAccessToken() + "<br/>" + 
						"ExpiresIn:" + response.getSession().getExpiresIn() + "<br/>" +
						"SignedRequest:" + response.getSession().getSignedRequest() + "<br/>" +
						"UserID:" + response.getSession().getUserID())));
			}
		}, "user_about_me,publish_stream,email");
	}

	private void getLoginStatus() {
		if (!initialized) {
			text.setHTML("Facebook plugin not initialized.");
			return;
		}
		Facebook.getLoginStatus(new Callback() {
			@Override
			public void onSuccess(Response response) {
				text.setHTML("Response from getLoginStatus:<br/>" +
						"Status:" + response.getStatus() + "<br/>" + 
						((response.getSession() == null) ? "" :
						("AccessToken:" + response.getSession().getAccessToken() + "<br/>" + 
						"ExpiresIn:" + response.getSession().getExpiresIn() + "<br/>" +
						"SignedRequest:" + response.getSession().getSignedRequest() + "<br/>" +
						"UserID:" + response.getSession().getUserID())));
			}
		});
	}

	private void post() {
		if (!initialized) {
			text.setHTML("Facebook plugin not initialized.");
			return;
		}
		Facebook.getLoginStatus(new Callback() {
			@Override
			public void onSuccess(Response response) {
				Session session = response.getSession();
				if (session == null) {
					text.setHTML("Need to login to Facebook first.");
					return;
				}
				String path = session.getUserID() + "/feed";
				Params params = Params.createParams();
				params.set("message", "Hello World!!!");
				Facebook.api(path, "post", params, new Callback() {
					@Override
					public void onSuccess(Response response) {
						if (response.get("id") != null) {
							text.setHTML(response.get("id"));
						}
						else {
							text.setHTML(new JSONObject(response).toString());
						}
					}
				});
			}
		});		
	}

	private void logout() {
		if (!initialized) {
			text.setHTML("Facebook plugin not initialized.");
			return;
		}
		Facebook.logout(new Callback() {
			@Override
			public void onSuccess(Response response) {
				text.setHTML("Response from logout:<br/>" +
						"Status:" + response.getStatus() + "<br/>" + 
						((response.getSession() == null) ? "" :
						("AccessToken:" + response.getSession().getAccessToken() + "<br/>" + 
						"ExpiresIn:" + response.getSession().getExpiresIn() + "<br/>" +
						"SignedRequest:" + response.getSession().getSignedRequest() + "<br/>" +
						"UserID:" + response.getSession().getUserID())));
			}
		});
	}
}

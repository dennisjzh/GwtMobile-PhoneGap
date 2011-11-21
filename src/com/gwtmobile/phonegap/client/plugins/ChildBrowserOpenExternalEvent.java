/*
 * Copyright 2010 Daniel Kurka
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

import com.google.gwt.event.shared.GwtEvent;

public class ChildBrowserOpenExternalEvent extends GwtEvent<ChildBrowserOpenExternalHandler> {

	private static final Type<ChildBrowserOpenExternalHandler> TYPE = new Type<ChildBrowserOpenExternalHandler>();

	public static Type<ChildBrowserOpenExternalHandler> getType() {
		return TYPE;
	}

	public ChildBrowserOpenExternalEvent() {

	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ChildBrowserOpenExternalHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ChildBrowserOpenExternalHandler handler) {
		handler.onOpenExternal(this);

	}

}

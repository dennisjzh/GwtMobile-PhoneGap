package com.gwtmobile.phonegap.client.plugins.mapkitplug;

import com.google.gwt.event.shared.GwtEvent;

/* Copyright (c) 2011 Smithimage (Robert Wallström)
 *
 * author: Robert Wallström
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
public class MapClickedEvent extends GwtEvent<MapClickedEventHandler> {

	private static final Type<MapClickedEventHandler> TYPE = new Type<MapClickedEventHandler>();
    private String pinIndex;

    public MapClickedEvent(String pinIndex){
        this.pinIndex = pinIndex;
    }

    public static Type<MapClickedEventHandler> getType() {
		return TYPE;
	}

    @Override
    public Type<MapClickedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(MapClickedEventHandler handler) {
        handler.onMapClicked(this);
    }

    public String getPinIndex() {
        return pinIndex;
    }
}

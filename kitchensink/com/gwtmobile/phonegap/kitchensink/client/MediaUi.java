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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.phonegap.client.Media;
import com.gwtmobile.phonegap.client.Media.Callback;
import com.gwtmobile.phonegap.client.Media.MediaError;
import com.gwtmobile.phonegap.client.Media.PositionCallback;

public class MediaUi extends Composite {

	private static MediaUiUiBinder uiBinder = GWT.create(MediaUiUiBinder.class);
	
	Media media;
	@UiField TextArea text;
	Timer timer;
	
	interface MediaUiUiBinder extends UiBinder<Widget, MediaUi> {
	}

	public MediaUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		
		media = Media.newInstance("http://freekidsmusic.com/traditional-songs-for-children/AlphabetSong.mp3", new Callback() {			
			@Override
			public void onSuccess() {
				text.setText("Media Success");
			}
			
			@Override
			public void onError(MediaError error) {
				text.setText("Media Error\n" +
						"Code: " + error.getCode() + "\n" +
						"Message: " + error.getMessage());
			}
		});		
	}

	@UiHandler("play")
    public void handlePlayClick(ClickEvent e) {
		media.play();
		timer = new Timer() {
			@Override
			public void run() {
				media.getCurrentPosition(new PositionCallback() {				
					@Override
					public void onSuccess(int position) {
						int duration = media.getDuration();
						text.setText(position + " / " + duration);
					}				
					@Override
					public void onError(MediaError error) {
						text.setText("Get Current Position Error\n" +
								"Code: " + error.getCode() + "\n" +
								"Message: " + error.getMessage());
					}
				});
			}
		};
		timer.scheduleRepeating(1000);
	}

	@UiHandler("pause")
    public void handlePauseClick(ClickEvent e) {
		media.pause();
		timer.cancel();
	}

	@UiHandler("stop")
    public void handleStopClick(ClickEvent e) {
		media.stop();
		timer.cancel();
	}

}

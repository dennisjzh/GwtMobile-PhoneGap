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
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.phonegap.client.FileMgr;
import com.gwtmobile.phonegap.client.FileMgr.*;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;

public class DirectoryUi extends Page {

	private static DirectoryUiUiBinder uiBinder = GWT.create(DirectoryUiUiBinder.class);
	
	@UiField HTML text;
	
	interface DirectoryUiUiBinder extends UiBinder<Widget, DirectoryUi> {
	}

	public DirectoryUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				init();
			}
		});
	}

	private void init() {
//		dirName = FileMgr.getRootPaths()[0] + "/gwtmobile-phonegap/";
//		fileName = dirName + "kitchensink-file.txt";
//		writer = FileMgr.newWriterInstance(fileName, true);
//		reader = FileMgr.newReaderInstance();
//
//		Callback callback = new Callback() {			
//			@Override
//			public void onEvent(Event evt) {
//				text.setHTML("Event Type: " + evt.getType() + "<br/>" + 
//						"FileName: " + evt.getTarget().getFileName() + "<br/>" +  
//						"Result: " + evt.getTarget().getResult() + "<br/>" +  
//						(evt.getType().equals("error") ? ("Error: " + evt.getTarget().getError().getCode() + "<br/>") : "") +  
//						text.getText());
//			}
//		};
//		
//		reader.onLoad(callback);
//		reader.onLoadStart(callback);
//		reader.onLoadEnd(callback);
//		reader.onProgress(callback);
//		reader.onAbort(callback);
//		reader.onError(callback);
//		
//		writer.onWriteStart(callback);
//		writer.onWriteEnd(callback);
//		writer.onWrite(callback);
//		writer.onProgress(callback);
//		writer.onAbort(callback);
//		writer.onError(callback);
	}
	
    @UiHandler("list0")
	void onList0SelectionChanged(SelectionChangedEvent e) {
    	switch (e.getSelection()) {
    	case 0:
    		getDirectory();
    		break;
    	case 1:
    		break;
    	case 2:
    		break;
    	case 3:
    		break;
    	case 4:
    		break;
    	case 5:
    		getFreeDiskSpace();
    		break;
    	}
    }


    private void getDirectory() {
    	FileMgr.requestFileSystem(LocalFileSystem.PERSISTENT, new FileSystemCallback() {
			@Override
			public void onSuccess(FileSystem fs) {
				fs.getRoot().getDirectory("gwtmobile-phonegap", new FileOptions().create(true), new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						DirectoryEntry dir = (DirectoryEntry) entry;
						text.setHTML("succeed:" + dir.getFullPath());
					}
					
					@Override
					public void onError(FileError error) {
						text.setHTML("error:" + error.getCode());
					}
				});
			}
			@Override
			public void onError(FileError error) {
				text.setHTML("error:" + error.getCode());
			}
		});
	}

	public void getFreeDiskSpace() {
		FileMgr.getFreeDiskSpace(new FreeDiskSpaceCallback() {			
			@Override
			public void onSuccess(double freeDiskSpace) {
				text.setHTML("Free Disk Space: " + freeDiskSpace);
			}			
			@Override
			public void onError(FileError error) {
				text.setHTML(error + "");
			}
		});
	}

}

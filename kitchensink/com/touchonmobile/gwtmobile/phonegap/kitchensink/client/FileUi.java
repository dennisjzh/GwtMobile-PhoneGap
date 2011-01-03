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
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.File;
import com.touchonmobile.gwtmobile.phonegap.client.File.Callback;
import com.touchonmobile.gwtmobile.phonegap.client.File.FreeDiskSpaceCallback;
import com.touchonmobile.gwtmobile.phonegap.client.File.Event;
import com.touchonmobile.gwtmobile.phonegap.client.File.FileError;
import com.touchonmobile.gwtmobile.phonegap.client.File.FileMgrCallback;
import com.touchonmobile.gwtmobile.phonegap.client.File.FileReader;
import com.touchonmobile.gwtmobile.phonegap.client.File.FileWriter;

public class FileUi extends Composite {

	private static FileUiUiBinder uiBinder = GWT.create(FileUiUiBinder.class);
	
	@UiField TextArea text;
	FileWriter writer;
	FileReader reader;
	String dirName;
	String fileName;
	
	interface FileUiUiBinder extends UiBinder<Widget, FileUi> {
	}

	public FileUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();

		dirName = File.getRootPaths()[0] + "gwtmobile-phonegap/";
		fileName = dirName + "kitchensink-file.txt";
		writer = File.newWriterInstance(fileName, true);
		reader = File.newReaderInstance();

		Callback callback = new Callback() {			
			@Override
			public void onEvent(Event evt) {
				text.setText("Event Type: " + evt.getType() + "\n" + 
						"FileName: " + evt.getTarget().getFileName() + "\n" +  
						"Result: " + evt.getTarget().getResult() + "\n" +  
						(evt.getType().equals("error") ? ("Error: " + evt.getTarget().getError().getCode() + "\n") : "") +  
						text.getText());
			}
		};
		
		reader.onLoad(callback);
		reader.onLoadStart(callback);
		reader.onLoadEnd(callback);
		reader.onProgress(callback);
		reader.onAbort(callback);
		reader.onError(callback);
		
		writer.onWriteStart(callback);
		writer.onWriteEnd(callback);
		writer.onWrite(callback);
		writer.onProgress(callback);
		writer.onAbort(callback);
		writer.onError(callback);
	}
	
	@UiHandler("write")
    public void handleWriteClick(ClickEvent e) {
		writer.write("Hello from gwtmobile-phonegap\n");
	}

	@UiHandler("truncate")
    public void handleTruncateClick(ClickEvent e) {
		writer.truncate(20);
	}

	@UiHandler("seek")
    public void handleSeekClick(ClickEvent e) {
		writer.seek(10);
	}

	@UiHandler("readdata")
    public void handleReadDataClick(ClickEvent e) {
		reader.readAsDataURL(fileName);
	}

	@UiHandler("readtext")
    public void handleReadTextClick(ClickEvent e) {
		reader.readAsText(fileName);
	}

	@UiHandler("abort")
    public void handleAbortClick(ClickEvent e) {
		writer.abort();
	}

	@UiHandler("file")
    public void handleFileExistsClick(ClickEvent e) {
		File.testFileExists(fileName, new FileMgrCallback() {			
			@Override
			public void onSuccess(boolean success) {
				text.setText("File: " + fileName + "\nFileExists: " + success);
			}			
			@Override
			public void onError(FileError error) {
				text.setText(error + "");
			}
		});
	}

	@UiHandler("dir")
    public void handleDirExistsClick(ClickEvent e) {
		File.testDirectoryExists(dirName, new FileMgrCallback() {			
			@Override
			public void onSuccess(boolean success) {
				text.setText("Dir: " + dirName + "\nDirExists: " + success);
			}			
			@Override
			public void onError(FileError error) {
				text.setText(error + "");
			}
		});
	}

	@UiHandler("create")
    public void handleCreateClick(ClickEvent e) {
		File.createDirectory(dirName, new FileMgrCallback() {			
			@Override
			public void onSuccess(boolean success) {
				text.setText("Dir: " + dirName + "\nCreate Dir: " + success);
			}			
			@Override
			public void onError(FileError error) {
				text.setText(error + "");
			}
		});
	}

	@UiHandler("deldir")
    public void handleDeleteDirClick(ClickEvent e) {
		File.deleteDirectory(dirName, new FileMgrCallback() {			
			@Override
			public void onSuccess(boolean success) {
				text.setText("Dir: " + dirName + "\nDelete Dir: " + success);
			}			
			@Override
			public void onError(FileError error) {
				text.setText(error + "");
			}
		});
	}

	@UiHandler("delfile")
    public void handleDeleteFileClick(ClickEvent e) {
		File.deleteFile(fileName, new FileMgrCallback() {			
			@Override
			public void onSuccess(boolean success) {
				text.setText("File: " + fileName + "\nDelete file: " + success);
			}			
			@Override
			public void onError(FileError error) {
				text.setText(error + "");
			}
		});
	}

	@UiHandler("diskspace")
    public void handleFreeDiskSpaceClick(ClickEvent e) {
		File.getFreeDiskSpace(new FreeDiskSpaceCallback() {			
			@Override
			public void onSuccess(double freeDiskSpace) {
				text.setText("Free Disk Space: " + freeDiskSpace);
			}			
			@Override
			public void onError(FileError error) {
				text.setText(error + "");
			}
		});
	}

}

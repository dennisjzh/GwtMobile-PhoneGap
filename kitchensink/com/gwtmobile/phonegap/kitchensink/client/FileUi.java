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
import com.gwtmobile.phonegap.kitchensink.client.DirectoryUi.DemoCallback;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;

public class FileUi extends Page {

	private static FileUiUiBinder uiBinder = GWT.create(FileUiUiBinder.class);
	
	@UiField HTML text;
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
    		getFile();
    		break;
    	case 1:
    		getMetadata();
    		break;
    	case 2:
    		isFile();
    		break;
    	case 3:
    		isDirectory();
    		break;
    	case 4:
    		getFile();
    		break;
    	case 5:
    		getFileInfo();
    		break;
    	case 6:
    		moveTo();
    		break;
    	case 7:
    		copyTo();
    		break;
    	case 8:
    		toURI();
    		break;
    	}
    }

    @UiHandler("list1")
	void onList1SelectionChanged(SelectionChangedEvent e) {
    	switch (e.getSelection()) {
    	case 0:
    		getFileParent();
//    		write();
    		break;
    	case 1:
    		truncate();
    		break;
    	case 2:
    		seek();
    		break;
    	case 3:
    		readAsDataURL();
    		break;
    	case 4:
    		readAsText();
    		break;
    	case 5:
    		abort();
    		break;
    	case 8:
    		remove();
    		break;
    	}
    }

    public void write() {
		writer.write("Hello from gwtmobile-phonegap<br/>");
	}

    public void truncate() {
		writer.truncate(20);
	}

    public void seek() {
		writer.seek(10);
	}

    public void readAsDataURL() {
//		reader.readAsDataURL(fileName);
	}

    public void readAsText() {
//		reader.readAsText(fileName);
	}

    public void abort() {
		writer.abort();
	}

    public void testFileExists() {
		FileMgr.testFileExists(fileName, new FileMgrCallback() {			
			@Override
			public void onSuccess(boolean success) {
				text.setHTML("File: " + fileName + "<br/>FileExists: " + success);
			}			
			@Override
			public void onError(FileError error) {
				text.setHTML(error + "");
			}
		});
	}

    public void testDirectoryExists() {
		FileMgr.testDirectoryExists(dirName, new FileMgrCallback() {			
			@Override
			public void onSuccess(boolean success) {
				text.setHTML("Dir: " + dirName + "<br/>DirExists: " + success);
			}			
			@Override
			public void onError(FileError error) {
				text.setHTML(error + "");
			}
		});
	}

    public void createDirectory() {
//		FileMgr.createDirectory(dirName, new FileMgrCallback() {			
//			@Override
//			public void onSuccess(boolean success) {
//				text.setHTML("Dir: " + dirName + "<br/>Create Dir: " + success);
//			}			
//			@Override
//			public void onError(FileError error) {
//				text.setHTML(error + "");
//			}
//		});
	}

    public void deleteDirectory() {
//		FileMgr.deleteDirectory(dirName, new FileMgrCallback() {			
//			@Override
//			public void onSuccess(boolean success) {
//				text.setHTML("Dir: " + dirName + "<br/>Delete Dir: " + success);
//			}			
//			@Override
//			public void onError(FileError error) {
//				text.setHTML(error + "");
//			}
//		});
	}

    public void deleteFile() {
//		FileMgr.deleteFile(fileName, new FileMgrCallback() {			
//			@Override
//			public void onSuccess(boolean success) {
//				text.setHTML("File: " + fileName + "<br/>Delete file: " + success);
//			}			
//			@Override
//			public void onError(FileError error) {
//				text.setHTML(error + "");
//			}
//		});
	}

    private void getFile() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(final FileEntry file) {
					text.setHTML("success: get file --" + file.getFullPath());
			}
		});
	}
    
    private void getMetadata() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(FileEntry file) {
				file.getMetadata(new MetadataCallback() {
					@Override
					public void onSuccess(Metadata metadata) {
						text.setHTML("succeed: last modification time -- " + metadata.getModificationTime().toString());
					}
					@Override
					public void onError(FileError error) {
						text.setHTML("error:" + error.getCode());
					}
				});
			}
		});
	}

    private void isFile() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(FileEntry file) {
				text.setHTML("is file -- " + file.isFile());
			}
		});
	}

    private void isDirectory() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(FileEntry file) {
				text.setHTML("is directory -- " + file.isDirectory());
			}
		});
	}

    private void getFileInfo() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(FileEntry file) {
				file.file(new FileCallback() {
					@Override
					public void onSuccess(File file) {
						text.setHTML( 
								"Name -- " + file.getName() + "<br/>" + 
								"Full Path -- " + file.getFullPath() + "<br/>" + 
//TODO: bug in phonegap. uncomment code below in 0.9.6.
//								"Last Modified -- " + file.getLastModifiedDate().toString() + "<br/>" + 
								"Size -- " + file.getSize() + "<br/>"
								);
					}
					@Override
					public void onError(FileError error) {
						text.setHTML("error:" + error.getCode());
					}
				});
			}
		});
	}

    private void moveTo() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(final FileEntry file) {
				file.getParent(new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						file.moveTo(entry, "backup-kitchensink.txt", new EntryCallback() {
							@Override
							public void onSuccess(Entry entry) {
								text.setHTML("success: move to -- " + entry.getFullPath());
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
		});
	}

    private void copyTo() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(final FileEntry file) {
				file.getParent(new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						file.copyTo(entry, "backup-kitchensink.txt", new EntryCallback() {
							@Override
							public void onSuccess(Entry entry) {
								text.setHTML("success: copy to -- " + entry.getFullPath());
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
		});
	}

    private void toURI() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(final FileEntry file) {
				text.setHTML("URI --" + file.toURI());
			}
		});
	}

    private void getFileParent() {
    	getDemoFile(new DemoCallback() {
			@Override
			public void onSuccess(final FileEntry file) {
				file.getParent(new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						text.setHTML("success: get parent -- " + entry.getFullPath());
					}
					@Override
					public void onError(FileError error) {
						text.setHTML("error:" + error.getCode());
					}
				});
			}
		});
	}
    
    private void remove() {
    	text.setHTML("");
    	DemoCallback callback = new DemoCallback() {
			@Override
			public void onSuccess(final FileEntry file) {
				file.remove(new FileMgrCallback() {
					@Override
					public void onSuccess(boolean success) {
						text.setHTML(text.getHTML() + "remove " + file.getFullPath() + " -- " + success + "<br/>");
					}
					@Override
					public void onError(FileError error) {
						text.setHTML("error:" + error.getCode());
					}
				});
			}
		};
    	getDemoFile("kitchensink.txt", callback);
    	getDemoFile("backup-kitchensink.txt", callback);
    }


    private void getDemoFile(final DemoCallback callback) {
    	getDemoFile("kitchensink.txt", callback);
    }
  
    private void getDemoFile(final String fileName, final DemoCallback callback) {
    	FileMgr.requestFileSystem(LocalFileSystem.PERSISTENT, new FileSystemCallback() {
			@Override
			public void onSuccess(FileSystem fs) {
				fs.getRoot().getDirectory("gwtmobile-phonegap", new FileOptions().create(true), new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						DirectoryEntry dir = (DirectoryEntry) entry;
						dir.getFile(fileName, new FileOptions().create(true), new EntryCallback() {
							@Override
							public void onSuccess(Entry entry) {
								FileEntry file = (FileEntry) entry;
								callback.onSuccess(file);
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
			@Override
			public void onError(FileError error) {
				text.setHTML("error:" + error.getCode());
			}
		});
	}
    
    interface DemoCallback {
    	void onSuccess(FileEntry file);
    }

}

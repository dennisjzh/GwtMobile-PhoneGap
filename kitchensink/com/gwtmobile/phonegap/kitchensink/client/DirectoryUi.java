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
	
    @UiHandler("list0")
	void onList0SelectionChanged(SelectionChangedEvent e) {
    	switch (e.getSelection()) {
    	case 0:
    		getDirectory();
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
    		getDirectory();
    		break;
    	case 5:
    		moveTo();
    		break;
    	case 6:
    		copyTo();
    		break;
    	case 7:
    		toURI();
    		break;
    	}
    }

    @UiHandler("list1")
	void onList1SelectionChanged(SelectionChangedEvent e) {
    	switch (e.getSelection()) {
    	case 0:
    		remove();
    		break;
    	case 1:
    		getDirParent();
    		break;
    	case 2:
    		break;
    	case 3:
    		break;
    	case 4:
    		break;
    	case 5:
    		break;
    	case 6:
    		break;
    	case 7:
    		break;
    	case 8:
    		break;
    	}
    }

    private void getDirectory() {
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(DirectoryEntry dir) {
				text.setHTML("succeed: directory full path -- " + dir.getFullPath());
			}
		});
	}

    private void getMetadata() {
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(DirectoryEntry dir) {
				dir.getMetadata(new MetadataCallback() {
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
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(DirectoryEntry dir) {
				text.setHTML("is file -- " + dir.isFile());
			}
		});
	}

    private void isDirectory() {
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(DirectoryEntry dir) {
				text.setHTML("is file -- " + dir.isDirectory());
			}
		});
	}

    private void moveTo() {
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(final DirectoryEntry dir) {
				dir.getParent(new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						DirectoryEntry parent = (DirectoryEntry) entry;
						dir.moveTo(parent, "backup-gwtmobile-phonegap", new EntryCallback() {
							@Override
							public void onSuccess(Entry entry) {
								text.setHTML("succeed: moved to --" + entry.getFullPath());
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
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(final DirectoryEntry dir) {
				dir.getParent(new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						DirectoryEntry parent = (DirectoryEntry) entry;
						dir.copyTo(parent, "backup-gwtmobile-phonegap", new EntryCallback() {
							@Override
							public void onSuccess(Entry entry) {
								text.setHTML("succeed: copied to --" + entry.getFullPath());
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
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(final DirectoryEntry dir) {
				text.setHTML("URI --" + dir.toURI());
			}
		});
	}

    private void remove() {
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(final DirectoryEntry dir) {
				dir.remove(new EventCallback() {
					@Override
					public void onEvent(Event evt) {
						text.setHTML("remove --" + evt.getTarget());
					}
				});
			}
		});
    }

    private void getDirParent() {
    	getDemoDirectory(new DemoCallback() {
			@Override
			public void onSuccess(final DirectoryEntry dir) {
				dir.getParent(new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						text.setHTML("succeed: parent --" + entry.getFullPath());
					}
					@Override
					public void onError(FileError error) {
						text.setHTML("error:" + error.getCode());
					}
				});
			}
		});
    }

    private void getDemoDirectory(final DemoCallback callback) {
    	FileMgr.requestFileSystem(LocalFileSystem.PERSISTENT, new FileSystemCallback() {
			@Override
			public void onSuccess(FileSystem fs) {
				fs.getRoot().getDirectory("gwtmobile-phonegap", new FileOptions().create(true), new EntryCallback() {
					@Override
					public void onSuccess(Entry entry) {
						DirectoryEntry dir = (DirectoryEntry) entry;
						callback.onSuccess(dir);
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

    interface DemoCallback {
    	void onSuccess(DirectoryEntry dir);
    }
}

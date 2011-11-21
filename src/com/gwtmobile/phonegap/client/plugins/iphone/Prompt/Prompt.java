package com.gwtmobile.phonegap.client.plugins.iphone.Prompt;

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
public class Prompt {

    public static native void show(String title, OkCallback okCallback, CancelCallback cancelCallback, String okButtonCaption, String cancelButtonCaption)/*-{
        $wnd.plugins.Prompt.show(title,
                function(userInput){
                    okCallback.@com.gwtmobile.phonegap.client.plugins.iphone.Prompt.OkCallback::onOk(Ljava/lang/String;)(userInput);
                },
                function(){
                    cancelCallback.@com.gwtmobile.phonegap.client.plugins.iphone.Prompt.CancelCallback::onCancel()();
                },
                okButtonCaption, cancelButtonCaption);
    }-*/;
}

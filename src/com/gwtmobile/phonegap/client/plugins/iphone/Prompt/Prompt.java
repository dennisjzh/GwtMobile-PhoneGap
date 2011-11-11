package com.gwtmobile.phonegap.client.plugins.iphone.Prompt;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 11/11/11
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
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

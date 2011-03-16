GWT Mobile Phonegap
===================

gwtmobile-phonegap is a GWT wrapper of the [PhoneGap](http://github.com/phonegap/phonegap) Javascript library. PhoneGap is a cross-platform development framework that provides core mobile device features to web-based mobile apps. GwtMobile-PhoneGap enables GWT mobile applications to use PhoneGap functions.

gwtmobile-phonegap is part of [GWT Mobile](http://github.com/dennisjzh/GwtMobile), a GWT mobile development platform.

Wrapped PhoneGap Functions
--------------------------

gwtmobile-phonegap has wrapped the following PhoneGap functions:

* Accelerometer: Tap into the device's motion sensor.
* Camera: Capture a photo using the device's camera.
* Compass: Obtain the direction that the device is pointing.
* Contacts: Work with the device's contact database.
* Device: Gather device specific information.
* Events: Hook into native events through JavaScript.
* File: Hook into native file system through JavaScript.
* Geolocation: Make your application location aware.
* Media: Record and play back audio files.
* Network: Quickly check the network state.
* Notification: Visual, audible, and tactile device notifications.

Note: the storage function is not currently wrapped, as webkit browsers all support database now. This function may become useful when PhoneGap works on Windows Mobile 7 phone, which does not have in-browser database support.

Sample Code
-----------

The java code below showcases how to call PhoneGap functions in an GWT mobile application using gwtmobile-phonegap. For more code samples, check out the `kitchensink` folder.

		String watchId = Accelerometer.watchAcceleration(new Callback() {			
			@Override
			public void onSuccess(Acceleration accel) {
				text.setText("Watch Acceleration" 
					+ "\nX: " + accel.getX()
					+ "\nY: " + accel.getY()
					+ "\nZ: " + accel.getZ());				
			}			
			@Override
			public void onError() {
				text.setText("Error");
			}
		}, new Options().frequency(100));


Apps that use GWT Mobile PhoneGap
---------------------------------

GWT Mobile PhoneGap: A PhoneGap showcase app, demonstrate all PhoneGap functions!
[Android Market](http://market.android.com/details?id=com.gwtmobile.phonegap), [iTunes App Store](http://itunes.apple.com/us/app/gwt-mobile-phonegap-showcase/id419032500?mt=8&ls=1) 

[Fantasy Predictor](http://www.touchonmobile.com): Manage all you Fantasy Football teams with the help of the Fantasy Predictor. 
[Android Market](http://market.android.com/details?id=com.TouchOnMobile.FantasyPredictor), [iTunes App Store](http://itunes.apple.com/us/app/fantasy-predictor/id405605997)


GWT Mobile Google Group
-----------------------

Have a question? Post it on the [GWT Mobile Google Group](http://groups.google.com/group/gwtmobile) 

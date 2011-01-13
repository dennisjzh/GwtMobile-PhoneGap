gwtmobile-phonegap
==================

gwtmobile-phonegap is an GWT wrapper of the PhoneGap Javascript library <http://github.com/phonegap/phonegap>. PhoneGap is a cross-platform development framework that provides core mobile device features to web-based mobile apps. GWT by Google <http://code.google.com/webtoolkit/> is a new way of developing web applications -- write apps in Java then compile into javascript. This GWT wrapper enables an GWT mobile application to use PhoneGap functions.

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

The java code below showcases how to call PhoneGap functions in an GWT mobile application using gwtmobile-phonegap. For more code samples, check out the `kitchensink` source code folder.

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


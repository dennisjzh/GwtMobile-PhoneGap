/*
 * Copyright (c) 2010 Zhihua (Dennis) Jiang
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

package com.touchonmobile.gwtmobile.phonegap.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Contacts {
	
	public static final native Contacts newInstance() /*-{
		return new $wnd.navigator.service.contacts.create();
	}-*/;
	
	public static class Contact extends JavaScriptObject {
		
		protected Contact() {}
		
		public static final native String getId() /*-{
			return this.id;
		}-*/;
	
		public static final native void setId(String id) /*-{
			this.id = id;
		}-*/;

		public static final native String getDisplayName() /*-{
			return this.displayName;
		}-*/;
	
		public static final native void setDisplayName(String displayName) /*-{
			this.displayName = displayName;
		}-*/;

		public static final native ContactName getName() /*-{
			return this.name;
		}-*/;
	
		public static final native void setName(ContactName name) /*-{
			this.name = name;
		}-*/;

		public static final native String getNickname() /*-{
			return this.nickname;
		}-*/;
	
		public static final native void setNickname(String nickname) /*-{
			this.nickname = nickname;
		}-*/;

		public static final native JsArray<ContactField> getPhoneNumbers() /*-{
			return this.phoneNumbers;
		}-*/;
	
		public static final native void getPhoneNumbers(JsArray<ContactField> phoneNumbers) /*-{
			this.phoneNumbers = phoneNumbers;
		}-*/;

		public static final native JsArray<ContactField> getEmails() /*-{
			return this.emails;
		}-*/;
	
		public static final native void setEmails(JsArray<ContactField> emails) /*-{
			this.emails = emails;
		}-*/;

		public static final native JsArray<ContactAddress> getAddresses() /*-{
			return this.addresses;
		}-*/;
	
		public static final native void setAddresses(JsArray<ContactAddress> addresses) /*-{
			this.addresses = addresses;
		}-*/;

		public static final native JsArray<ContactField> getIMs() /*-{
			return this.ims;
		}-*/;
	
		public static final native JsArray<ContactOrganization> getOrganizations() /*-{
			return this.organizations;
		}-*/;
	
		public static final native String getPublished() /*-{
			return this.published;
		}-*/;
	
		public static final native String getUpdated() /*-{
			return this.updated;
		}-*/;
	
		public static final native String getBirthday() /*-{
			return this.birthday;
		}-*/;
	
		public static final native String getAnniversary() /*-{
			return this.anniversary;
		}-*/;
	
		public static final native String getGender() /*-{
			return this.gender;
		}-*/;
	
		public static final native String getNote() /*-{
			return this.note;
		}-*/;
	
		public static final native String getPreferredUsername() /*-{
			return this.preferredUsername;
		}-*/;
	
		public static final native JsArray<ContactField> getPhotos() /*-{
			return this.photos;
		}-*/;
	
		public static final native JsArray<ContactField> getTags() /*-{
			return this.tags;
		}-*/;
	
		public static final native JsArray<ContactField> getRelationships() /*-{
			return this.relationships;
		}-*/;
	
		public static final native JsArray<ContactField> getURLs() /*-{
			return this.urls;
		}-*/;
	
		public static final native JsArray<ContactAccount> getAccounts() /*-{
			return this.accounts;
		}-*/;
	
		public static final native String getUTCOffset() /*-{
			return this.utcOffset;
		}-*/;
	
		public static final native boolean getConnected() /*-{
			return this.connected;
		}-*/;
	}

	public static class ContactName extends JavaScriptObject {
		
		protected ContactName() {};
		
		public final native String getFormatted() /*-{
			return this.formatted;
		}-*/;

		public final native String getFamilyName() /*-{
			return this.familyName;
		}-*/;

		public final native String getGivenName() /*-{
			return this.givenName;
		}-*/;

		public final native String getMiddleName() /*-{
			return this.middleName;
		}-*/;

		public final native String getHororificPrefix() /*-{
			return this.hororificPrefix;
		}-*/;

		public final native String getHonorificSuffix() /*-{
			return this.honorificSuffix;
		}-*/;

	}

	public static class ContactField extends JavaScriptObject {
		
		protected ContactField() {};
		
		public final native String getType() /*-{
			return this.type;
		}-*/;

		public final native String getValue() /*-{
			return this.value;
		}-*/;

		public final native boolean getPrimary() /*-{
			return this.primary;
		}-*/;

	}
	
	public static class ContactAddress extends JavaScriptObject {
		
		protected ContactAddress() {};
		
		public final native String getFormatted() /*-{
			return this.formatted;
		}-*/;

		public final native String getStreetAddress() /*-{
			return this.streetAddress;
		}-*/;

		public final native String getLocality() /*-{
			return this.locality;
		}-*/;

		public final native String getRegion() /*-{
			return this.region;
		}-*/;

		public final native String getPostalCode() /*-{
			return this.postalCode;
		}-*/;

		public final native String getCountry() /*-{
			return this.country;
		}-*/;

	}

	public static class ContactOrganization extends JavaScriptObject {
		
		protected ContactOrganization() {};
		
		public final native String getName() /*-{
			return this.name;
		}-*/;

		public final native String getDepartment() /*-{
			return this.department;
		}-*/;

		public final native String getTitle() /*-{
			return this.title;
		}-*/;

		public final native String getStartDate() /*-{
			return this.startDate;
		}-*/;

		public final native String getEndDate() /*-{
			return this.endDate;
		}-*/;

		public final native String getLocation() /*-{
			return this.location;
		}-*/;

		public final native String getDescription() /*-{
			return this.description;
		}-*/;

	}

	public static class ContactAccount extends JavaScriptObject {
		
		protected ContactAccount() {};
		
		public final native String getDomain() /*-{
			return this.domain;
		}-*/;

		public final native String getUserName() /*-{
			return this.username;
		}-*/;

		public final native String getUserId() /*-{
			return this.userid;
		}-*/;

	}

}

package com.fashion.base;




import java.io.IOException;

import javax.ws.rs.core.Request;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;

import com.fashion.entity.GoogleEntity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GoogleUntils {
	
	public static String getToken(final String code) throws ClientProtocolException, IOException {
	    String response = org.apache.http.client.fluent.Request.Post(ConstraintsGoole.GOOGLE_LINK_GET_TOKEN)
	        .bodyForm(Form.form().add("client_id", ConstraintsGoole.GOOGLE_CLIENT_ID)
	            .add("client_secret", ConstraintsGoole.GOOGLE_CLIENT_SECRET)
	            .add("redirect_uri",ConstraintsGoole.GOOGLE_REDIRECT_URI).add("code", code)
	            .add("grant_type", ConstraintsGoole.GOOGLE_GRANT_TYPE).build())
	        .execute().returnContent().asString();
	      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
	      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
	      return accessToken;
	  }
	  public static GoogleEntity getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
	    String link = ConstraintsGoole.GOOGLE_LINK_GET_USER_INFO + accessToken;
	    String response = org.apache.http.client.fluent.Request.Get(link).execute().returnContent().asString();
	    GoogleEntity googlePojo = new Gson().fromJson(response, GoogleEntity.class);
	    System.out.println(googlePojo);
	    return googlePojo;
	  }


}

package com.basic.sample;

import java.util.*;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class RestSample {

	@Test
	public void SampleTest_1() {
		
		Response response =  RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("getStatusCode" + response.getStatusCode());
		System.out.println("getStatusLine" + response.getStatusLine());
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		System.out.println("page        :" + jsonPathEvaluator.get("page"));
		System.out.println("per_page    :" + jsonPathEvaluator.get("per_page"));
		System.out.println("total       :" + jsonPathEvaluator.get("total"));
		System.out.println("total_pages :" + jsonPathEvaluator.get("total_pages"));
		System.out.println("data        :" + jsonPathEvaluator.get("data").toString());
		
        Assert.assertEquals(jsonPathEvaluator.get("page"), 2, "Correct page received in the Response");

		 
		System.out.println("response.asString()     :  "+ response.asString());
		
		JSONObject json =new JSONObject(response.asString());  
		   
				    System.out.println("page    :  " + json.get("page"));
					System.out.println("per_page   :  " + json.get("per_page"));
					System.out.println("total  :  " + json.get("total"));
					System.out.println("total_pages   :  "+ json.get("total_pages"));
		   
           JSONArray array = json.getJSONArray("data" );
           for(int i=0;i<array.length();i++){
               JSONObject user =array.getJSONObject(i);   
               System.out.println("id:   "+ user.get("id") + "     email:   "+ user.get("email") +  "      first_name:   "+ user.get("first_name") + "    last_name:   "+ user.get("last_name") + "    avatar:   "+ user.get("avatar") );
           }
           
   
       }
	
	
		
	}
	
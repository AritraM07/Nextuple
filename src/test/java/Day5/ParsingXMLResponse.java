package Day5;

import org.testng.Assert;
import  org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

import org.json.JSONObject;

public class ParsingXMLResponse 
{
	//@Test(priority = 1)
    void testXMLResponse() 
	{
        // Capture the response by sending the GET request to the server
		// Approach 1
		/*
       given()
       
       
	   .when()
	    	.get("http://restapi.adequateshop.com/api/Traveler?page=1")
	   .then()
	        .statusCode(200)
       		.header("Content-Type", "application/xml; charset=utf-8")
       		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
       		.log().all();
       		*/
		
		Response res = 
				given()
				
				.when()
		    		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		Assert.assertEquals(res.getStatusCode(), 200);
		
		String traveler_name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(traveler_name, "Developer");		
	}
    @Test
    void testXMLResponseBody()
    {
    	Response res = given()
    			
    			.when()
    				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
    			XmlPath obj = new XmlPath(res.asString());
    			List<String> travelers = obj.getList("TravelerinformationResponse.travelers.Travelerinformation");
    			Assert.assertEquals(travelers.size(), 10);
    			
    			boolean status = false;
    			List<String> travelers_name = obj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
    			for(String k: travelers_name)
    			{
    				//System.out.println(k);
    				if(k.equals("vano"))
    				{
    					status = true;
    					break;
    				}
    			}
    			
    			Assert.assertEquals(status, true);
    }
}

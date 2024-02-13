package Day4;

import org.testng.Assert;
import  org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData 
{
	
	//@Test(priority = 1)
    void testJSONResponse() {
        // Capture the response by sending the GET request to the server
		// Approach 1
		/*
       given()
       
       
	   .when()
	    	.get("http://localhost:3000/store")
	   .then()
	        .statusCode(200)
	        .log().all()
	        .body("book[1].title", equalTo("Sword of Honour"));*/
		
		// Approach 2
		Response res = given()
						.contentType(ContentType.JSON)
		
				.when()
					.get("http://localhost:3000/store");
					
				Assert.assertEquals(res.statusCode(), 200);
				Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
				
				String bookname = res.jsonPath().get("book[1].title").toString();
				Assert.assertEquals(bookname, "Sword of Honour");
				
	}
     
	@Test(priority = 1)
    void testJSONResponseBodyData() {
		Response res = given()
						.contentType(ContentType.JSON)
		
				.when()
					.get("http://localhost:3000/store");
					
				/*Assert.assertEquals(res.statusCode(), 200);
				Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
				
				String bookname = res.jsonPath().get("book[1].title").toString();
				Assert.assertEquals(bookname, "Sword of Honour");
				*/
		
			JSONObject jo = new JSONObject(res.asString());
			boolean status = false;
			double totalPrice = 0.0;
			for(int i = 0; i < jo.getJSONArray("book").length(); i++)
			{
				String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
				totalPrice = totalPrice + Double.parseDouble(price);
				//System.out.println(bookTitle);
				
				if(bookTitle.equals("Sword of Honour"))
				{
					status = true;
					break;
				}
			}
			
			Assert.assertEquals(status, true);
			//System.out.println(totalPrice);
			Assert.assertEquals(totalPrice, 250.5);
	}
	
	
}

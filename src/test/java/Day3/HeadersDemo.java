package Day3;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

//import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class HeadersDemo 
{
	@Test
	void testCookies()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		//String header_value = res.getHeader("Content-Type");
		//System.out.println("The content of Content-Type header is: " + header_value);
		
		Headers myheaders = res.getHeaders();
		
		for(Header hd:myheaders)
		{
			//String header_value = res.getHeader("hd");
			//System.out.println(hd +"   :" + header_value);
			//Alternate way
			
			System.out.println(hd.getName() +"   " + hd.getValue());
			
		}
	}
}

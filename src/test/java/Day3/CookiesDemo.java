package Day3;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

//import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
public class CookiesDemo 
{
	@Test
	void testCookies()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		//String cookie_value = res.getCookie("AEC");
		//System.out.print("The value of the cookie is===>" + cookie_value);
		Map<String, String> cookies_values = res.getCookies();
		//System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k + "     " + cookie_value);
		}
	}
	
	
}

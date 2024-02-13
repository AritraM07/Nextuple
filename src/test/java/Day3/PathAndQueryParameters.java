package Day3;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
//import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


//https://reqres.in/api/users?page=2&id=5
public class PathAndQueryParameters 
{
	@Test
	void testQueryAndPathParameters()
	{
		given()
			.pathParam("myPath", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		.when()
			.get("https://reqres.in/api/{myPath}")
		
		.then()	
			.statusCode(200)
			.log().all();
	}

}

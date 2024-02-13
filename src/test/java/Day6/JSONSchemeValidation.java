package Day6;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

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
public class JSONSchemeValidation 
{
	@Test
	void jsonschemevalidation()
	{
		given()
		
		.when()
			.get(" http://localhost:3000/store")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));

		
	}
}

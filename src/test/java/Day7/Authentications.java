package Day7;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Authentications 
{
	@Test(priority = 1)
	void testBasicAuthentication()
	{
		given()
			.auth().basic("postman", "password")
		.when()
			.get("http://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	

	@Test(priority = 2)
	void testDigestAuthentication()
	{
		given()
			.auth().digest("postman", "password")
		.when()
			.get("http://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	

	@Test(priority = 3)
	void testPreemptiveAuthentication()
	{
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("http://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test(priority = 4)
	
	void testBearerTokenAuthentication()
	{
		given()
			.headers("Authorization", "Bearer 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")
		.when()
			.get("https://api.github.com/users/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	void testOAuth2Authentication()
	{
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/users/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
}

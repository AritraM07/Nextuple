package Day8;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser 
{
	@Test
	
	void test_getUser(ITestContext context)
	{
		//int id = (Integer) context.getAttribute("user_id"); // To access test level variable
		int id = (Integer) context.getSuite().getAttribute("user_id"); // To access suite level variable 
		String bearerToken = "66ed03003f73b0a0368e1ae1670e86bd2b3a2cf7a49e8e670df8b57f0d091603";
		
		given()
			.headers("Authorization", "Bearer " + bearerToken)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
			
	}
}

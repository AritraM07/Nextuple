package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser 
{
	@Test
	void test_DeleteUser(ITestContext context)
	{
		String bearerToken = "66ed03003f73b0a0368e1ae1670e86bd2b3a2cf7a49e8e670df8b57f0d091603";
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		given()
			.headers("Authorization", "Bearer " + bearerToken)
			.pathParam("id", id)
			
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(204)
			.log().all();
	}
}

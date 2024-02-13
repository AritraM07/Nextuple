package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser 
{
	@Test
	void test_UpdateUser(ITestContext context)
	{
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName()); // 'name' should be in lowercase
		data.put("email", faker.internet().emailAddress()); // Add 'email' field
		data.put("gender", "male"); // Assuming you want to set gender as 'male'
		data.put("status", "Inactive"); // Include 'status'

		String bearerToken = "66ed03003f73b0a0368e1ae1670e86bd2b3a2cf7a49e8e670df8b57f0d091603";
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		given()
			.headers("Authorization", "Bearer " + bearerToken)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}
}

package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser 
{
	@Test
	void tes_createUser(ITestContext context)
	{
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName()); // 'name' should be in lowercase
		data.put("email", faker.internet().emailAddress()); // Add 'email' field
		data.put("gender", "male"); // Assuming you want to set gender as 'male'
		data.put("status", "Inactive"); // Include 'status'

		String bearerToken = "66ed03003f73b0a0368e1ae1670e86bd2b3a2cf7a49e8e670df8b57f0d091603";
		
		Response res = given()
			.headers("Authorization", "Bearer " + bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users");
		
		int id = res.jsonPath().getInt("id");
		System.out.println(id);
		
		//context.setAttribute("user_id", id); Variable "user_id" only available to 
		context.getSuite().setAttribute("user_id", id); // variable "user_id" available to all tests in suite
		
	}
}

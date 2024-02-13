package Day7;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class DummyData 
{
	@Test
	void testGenerateDummyData()
	{
		Faker faker = new Faker();
		String fullname = faker.name().fullName();
		String username = faker.name().username();
		String password = faker.internet().password();
		String phno = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		
		
		
		System.out.println("Fullname: " + fullname);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Phone no: " + phno);
		System.out.println("Email ID: " + email);
	}
}

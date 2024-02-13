package Day6;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Day2.Pojo_PostRequest;

//import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
public class SerializationDeserialization 
{
	@Test(priority = 1)
	void convertPojo2Json() throws JsonProcessingException
	{
		Student data = new Student();
    	data.setName("Scott");
    	data.setLocation("France");
    	data.setPhone("123456");
    	String coursesArr[] = {"C", "C++"};
    	data.setCourses(coursesArr);
    	
    	ObjectMapper obj = new ObjectMapper();
    	String jsondata = obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    	System.out.println(jsondata);
	}
	
	@Test(priority = 2)
	void Json2Pojo() throws JsonProcessingException
	{
		String Jsondata = "{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		ObjectMapper obj = new ObjectMapper();
		Student stu = obj.readValue(Jsondata, Student.class);
		System.out.println("Name: " + stu.getName());
		System.out.println("Location: " + stu.getLocation());
		System.out.println("Phone: " + stu.getPhone());
		System.out.println("Course 1: " + stu.getCourses()[0]);
		System.out.println("Course 2: " + stu.getCourses()[1]);
	}
}

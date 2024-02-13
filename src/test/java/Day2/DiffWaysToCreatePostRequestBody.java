package Day2;

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

public class DiffWaysToCreatePostRequestBody {

    //@Test(priority = 1)
    public void testPostUsingHashMap() {
        HashMap data = new HashMap();
        data.put("Name", "Eden");
        data.put("Location", "Austria");
        data.put("phone", 67856);
        String courseArr[] = {"Java", "Python"};
        data.put("Courses", courseArr);

        given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("http://localhost:3000/students")
        .then()
            .statusCode(201)
            .body("Name", equalTo("Eden"))
            .body("Courses[0]", equalTo("Java"))
            .log().all();
    }
    
   // @Test(priority = 1)
    public void testPostUsingJsonLibrary() {
        JSONObject data = new JSONObject();
        data.put("Name", "Scott");
        data.put("Location", "France");
        data.put("phone", 123456);
        String courseArr[] = {"C", "C++"};
        data.put("Courses", courseArr);

        given()
            .contentType("application/json")
            .body(data.toString())
        .when()
            .post("http://localhost:3000/students")
        .then()
            .statusCode(201)
            .body("Name", equalTo("Scott"))
            .body("Courses[0]", equalTo("C"))
            .log().all();
    }
    
    //@Test(priority = 1)
    public void testPostUsingPOJO() 
    {
    	Pojo_PostRequest data = new Pojo_PostRequest();
    	data.setName("Scott");
    	data.setLocation("France");
    	data.setPhone("123456");
    	String coursesArr[] = {"C", "C++"};
    	data.setCourses(coursesArr);
    	
    	given()
        	.contentType("application/json")
        	.body(data)
        .when()
        	.post("http://localhost:3000/students")
        .then()
	        .statusCode(201)
	        .body("name", equalTo("Scott"))
	        .body("courses[0]", equalTo("C"))
	        .log().all();
    	
    }
    
    @Test(priority = 1)
    public void testPostUsingExternalFile() throws FileNotFoundException 
    {
    	File f = new File(".\\body.json");
    	FileReader fr = new FileReader(f);
    	JSONTokener jt = new JSONTokener(fr);
    	JSONObject data = new JSONObject(jt);
    	
    	given()
        	.contentType("application/json")
        	.body(data.toString())
        .when()
        	.post("http://localhost:3000/students")
        .then()
	        .statusCode(201)
	        .body("name", equalTo("Scott"))
	        .body("courses[0]", equalTo("C"))
	        .log().all();
    	
    }
    
    
    
    
    @Test(priority = 2)
    void testDelete()
    {
    	given()
    	
    	.when()
    		.delete("http://localhost:3000/students/4")
    	.then()
    		.statusCode(200);
    }
}

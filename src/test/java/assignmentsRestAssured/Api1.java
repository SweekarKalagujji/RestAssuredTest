package assignmentsRestAssured;

import java.util.HashMap;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Api1 {
  @Test(priority=1)
  public void createUserMap()
  {     System.out.println("Creating  new user using HashMap");
	    HashMap<String,Object>data = new HashMap<String,Object>();
	    data.put("name","Sweekar");
	    data.put("job","Tester");
	  
	    given()
	   .contentType("application/json")  
	   .body(data)
	   .when().post("https://reqres.in/api/users")
	   .then().statusCode(201)
	   .log().body();  
  }
  @Test(priority=2)
  public void createUserPojo() 
  {   
	  System.out.println("Creating  new user using POJO");
	  PojoDemo pojo = new PojoDemo();
	  pojo.setName("Shreeja");
	  pojo.setJob("Data Analyst");
	  
	  given()
	  .contentType("application/json")
	  .body(pojo)
	  .when().post("https://reqres.in/api/users")
	  .then().statusCode(201).log().body();  
  }  
  
}

package htmlMethods;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PostRequest {
  @Test(priority=1)
  public void post_HashMap() {
	  
	  HashMap<String,Object>m1=new HashMap< String,Object>();
	  m1.put("Name","Sweekar");
	  m1.put("Job","tester");
	  
	  given()
	  .contentType("application/json")
	  .body(m1)
	  
	  .when().post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	  .log().body();
	  
	  
  }
  @Test(priority=2)
  public void post_Pojo() {
	  PojoClass pojo= new PojoClass();
	  pojo.setName("Shreeja");
	  pojo.setJob("Data Analyst");
	  
	  given()
	  .contentType("application/json")
	  .body(pojo)
	  .when()
	  .post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	  .log()
	  .body();
	  
  }
  
}

package htmlMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Put_Delete_Request {
  @Test(priority=1)
  public void putRequest() {
	  PojoClass pojo= new PojoClass();
	  pojo.setName("Tasvi");
	  pojo.setJob("Developer");
	  
	  given()
	  .contentType("application/json")
	  .body(pojo)
	  .when()
	  .put("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .log()
	  .body();
  }
  @Test(priority=2)
  public void patchRequest() {
	  PojoClass pojo= new PojoClass();
	  pojo.setName("Sanjay");
	  
	  given()
	  .contentType("application/json")
	  .body(pojo)
	  .when()
	  .patch("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .log()
	  .body();
  }
  @Test(priority=3)
  public void deleteRequest() {
	 
	  given()
	 
	  .when()
	  .delete("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(204)
	  .log()
	  .body();
  }
  
}


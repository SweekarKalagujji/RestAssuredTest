package assignmentsRestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Api3 {
  @Test(priority=1)
  public void getUser1() {
	  System.out.println("User list from page 1: ");
	  given()
	  .pathParam("path","users")
	  .queryParam("page",1)
	  .when().get("https://reqres.in/api/{path}")
	  .then().log().body();
  }
  
  @Test(priority=2)
  public void getUser2() {
	  System.out.println("User list from page 2: ");
       given()
	  .pathParam("path","users")
	  .queryParam("page",2)
	  .when().get("https://reqres.in/api/{path}")
	  .then().log().body();
  }
  
}

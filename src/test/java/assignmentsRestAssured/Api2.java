package assignmentsRestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Api2 {
	  @Test
	  public void deleteUser() 
	  {    
		   given()
		  .when().delete(" https://reqres.in/api/users/2")
		  .then().statusCode(204);
		   System.out.println("Deleted User!");
		  
	  }  
}

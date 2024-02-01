package assignmentsRestAssured;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class Api4
{
	  @Test
	  public void outh2Auth() 
	  {
		  given()
		  .auth().oauth2("//add token here")
		  .when().get("https://api.github.com/user/repos")
		  .then()
		  .log()
		  .body();
		  System.out.println("Auth 2 Authentication is completed!");
	  }
}

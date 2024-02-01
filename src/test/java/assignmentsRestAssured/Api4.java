package assignmentsRestAssured;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class Api4
{
	  @Test
	  public void outh2Auth() 
	  {
		  given()
		  .auth().oauth2("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")
		  .when().get("https://api.github.com/user/repos")
		  .then()
		  .log()
		  .body();
		  System.out.println("Auth 2 Authentication is completed!");
	  }
}

package htmlMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class AuthenticationRestAssured {
  @Test(priority=1)
  public void basicAuth() {
	  
	  given()
	  .auth().basic("postman","password")
	  .when().get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log()
	  .body();
	  System.out.println("Basic Authentication is completed!");
  }
  @Test(priority=2)
  public void digestAuth() {
	  
	  given()
	  .auth().digest("postman","password")
	  .when().get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log()
	  .body();
	  System.out.println("Digest Authentication is completed!");
  }
  @Test(priority=3)
  public void preemptiveAuth() {
	  
	  given()
	  .auth().preemptive().basic("postman","password")
	  .when().get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log()
	  .body();
	  System.out.println("Preemptive Authentication is completed!");
  }
  @Test(priority=4)
  public void bearerTokenAuth() {
	  
	  given()
	  .header("Authorization","Bearer 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")
	  .when().get("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .all();
	  System.out.println("Bearer Token Authentication is completed!");
  }
  @Test(priority=5)
  public void outh2Auth() {
	  
	  given()
	  .auth().oauth2("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")
	  .when().get("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body();
	  System.out.println("Auth 2 Authentication is completed!");
  }
}

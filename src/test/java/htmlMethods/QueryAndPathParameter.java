package htmlMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class QueryAndPathParameter {
  @Test
  public void queryAndPath() {
	  given()
	  .pathParam("path","users")
	  .queryParam("page",2)
	  .when().get("https://reqres.in/api/{path}")
	  .then().log().all();
  }
}

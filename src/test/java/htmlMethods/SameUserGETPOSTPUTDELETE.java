package htmlMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class SameUserGETPOSTPUTDELETE {
	String id;
  @Test(priority=1)
  public void createUser() {
	  PojoClass pojo= new PojoClass();
	  pojo.setName("Vismaya");
	  pojo.setJob("CA");
	  
	   id=given()
	  .contentType("application/json")
	  .body(pojo)
	  .when()
	  .post("https://reqres.in/api/users")
	  .jsonPath().get("id");
	   System.out.println("User is created with id: "+id);
	  
 }
  
  @Test(priority=2)
  public void getUser() {
	  
	   given()
	  .when()
	  .get("https://reqres.in/api/users/2"+id)
	  .then().log().body();
	   System.out.println("User display with same id: "+id);
}
  @Test(priority=3)
  public void updateUser() {
	  PojoClass pojo= new PojoClass();
	  pojo.setName("Nagabhushan");
	  pojo.setJob("Doctor");
	  
	   given()
	  .contentType("application/json")
	  .body(pojo)
	  .when()
	  .put("https://reqres.in/api/users/2"+id)
	  .then().statusCode(200)
	  .log().body();

	   System.out.println("User is updated with id: "+id);
	  
 }
  @Test(priority=4)
  public void deleteUser() {
	  
	   given()
	  .when()
	  .delete("https://reqres.in/api/users/2"+id)
	  .then().statusCode(204);
	   System.out.println("User is deleted with same id: "+id);
}}
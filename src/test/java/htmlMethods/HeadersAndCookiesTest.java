package htmlMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class HeadersAndCookiesTest {
  @Test(priority=1)
  public void testHeader() {
	   given()
	  .when().get("https://www.google.com/")
	   .then().log().headers();
	  
  }
  @Test(priority=2)
  public void validateHeader() {
	   Response res =given()
	  .when().get("https://www.google.com/");
	   
	  String act= res.getHeader("Content-Type");
	   
	   Assert.assertEquals(act,"text/html; charset=ISO-8859-1");
	   System.out.println("Header is validated!");
	  
  }
  @Test(priority=3)
  public void validateCookies() {
	   Response res =given()
	  .when().get("https://www.google.com/");
	   
	   Map<String,String>ma=res.getCookies();
	   System.out.println(ma);
	   
	 String s=  res.getCookie("AEC");
	  
	   
	   Assert.assertFalse(s.contains("Ae3NU9MqWlUsGzLmEiU0KceQj8so46eaXrBtvJHlBnoZbLMDvvnT33i5ARk; expires=Sun, 14-Jul-2024 12:50:15 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax"));
	   System.out.println("Cookie is validated!");
	  
  }
  
  
}

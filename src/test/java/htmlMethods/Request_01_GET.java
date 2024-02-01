package htmlMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Request_01_GET
{
  @Test
  public void getRequest_SingleUser() {
	  
	 Response res=  RestAssured.get("https://reqres.in/api/users/2");
	 int exp= res.statusCode();
	 System.out.println("Response status code is : "+exp);
	 Assert.assertEquals(200,exp,"Fail: Status code isnt matching");
	 System.out.println("Pass: Status code is matched! ");
	 System.out.println(res.statusLine());
	 System.out.println(res.sessionId());
	  

  }
}

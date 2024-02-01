package htmlMethods;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization_Deserialization {
  @Test(priority=1)
  public void testSerialisation() throws JsonProcessingException {
	  PojoClass pojo = new PojoClass();
	  pojo.setName("Parvathi");
	  pojo.setJob("Teacher");
	  
	  ObjectMapper om= new ObjectMapper();
	  String json=om.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
	  System.out.println(json);
	  
  }
  @Test(priority=2)
  public void testDeserialisation() throws JsonMappingException, JsonProcessingException {
	  String json="{\n"
	  		+ "  \"name\" : \"Parvathi\",\n"
	  		+ "  \"job\" : \"Teacher\"\n"
	  		+ "}";
	  ObjectMapper om = new ObjectMapper();
	  PojoClass p = om.readValue(json,PojoClass.class);
	  System.out.println(p.getName() +":"+p.getJob());
  }
}

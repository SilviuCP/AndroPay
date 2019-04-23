package communication;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {
  
  private static ObjectMapper mapper = new ObjectMapper();
  
  public static String createJsonResponse(Response r) {
    
    try {
      return mapper.writeValueAsString(r);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return "Failed to convert response to Json";
    
  }
  
  public static <T extends ResponseImpl> T readJsonResponse(String r, Class<T> type){
    ResponseImpl response = new ResponseImpl();
    try {
       response = mapper.readValue(r, type);

      return (T)response;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return (T)response;
  }
  
}

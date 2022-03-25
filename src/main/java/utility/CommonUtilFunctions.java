package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {

	public static JsonPath jsonPath;
	
	public static String getResponseKeyValue(String responseBody, String responseKey) {
		//takes a response as a string and returns the required value based on the string responseKey parameter
		//converting to a JsonPath
		jsonPath = new JsonPath(responseBody);
		//getting the required value from jsonPath and storing as a string
		String key_value = jsonPath.get(responseKey);
		
		return key_value;
	}
	
	public static int getStatusCode(Response response) {
		int status_code = response.getStatusCode();
		return status_code;
	}
	
	public static String getStatusMessage(Response response) {
		String status_message = response.getStatusLine();
		return status_message;
	}
	
	public static String getResponseHeader(Response response, String header_key) {
		String response_header = response.getHeader(header_key);
		return response_header;
	}
	
	public static String getResponseContentType(Response response) {
		String content_type = response.getContentType();
		return content_type;
	}
}

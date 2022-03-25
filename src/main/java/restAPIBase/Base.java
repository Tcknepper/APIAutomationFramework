package restAPIBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	//method for making a get request
	public static Response getRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		return response;
	}

	//method for making a post request with no authentication
	public static Response postRequest(String requestURI, String requestPayload) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		return response;
	}
	
	//method for making a post request with authentication
	public static Response postRequest(String requestURI, String requestPayload, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " +bearer_token);
		Response response = requestSpecification.post(requestURI);
		return response;
	}

	//method for making a put request
	public static Response putRequest(String requestURI, String requestPayload) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		return response;
	}

	//method for making a delete request with no authentication
	public static Response deleteRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}
	
	//method for making a delete request with authentication
	public static Response deleteRequest(String requestURI, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " +bearer_token);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}
	
	//method for making a delete request using a payload
	public static Response deleteRequestWithPayload(String requestURI, String requestPayload) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}
}

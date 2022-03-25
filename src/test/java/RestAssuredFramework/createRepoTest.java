package RestAssuredFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import pojoClasses.CreateRepoPOJO;
import restAPIBase.Base;
import utility.Authenticate;
import utility.CommonUtilFunctions;
import utility.createURL;
import utility.payloadGenerator;

public class createRepoTest extends Base{

	//declared globally to avoid redeclaring in each test case
	Response response; 
	ObjectMapper objectMapper;
	String endPoint = createURL.getBaseURI("/user/repos");
	String bearer_Token = Authenticate.getBearerToken();
	CreateRepoPOJO requestPayload;
	
	@Test
	public void createRepositoryPayloadTest() throws IOException {
		//declaring string to store the json payload that is generated
		String req_Payload = payloadGenerator.generateStringPayload("createRepo.json");
		
		//making the post request and storing the response and converting it to a string
		response = postRequest(endPoint, req_Payload, bearer_Token);
		String responseString = response.getBody().asString();
		
		//asserting that the values passed are the same values returned
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"), CommonUtilFunctions.getResponseKeyValue(req_Payload, "name"));
		softAssert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"), CommonUtilFunctions.getResponseKeyValue(req_Payload, "description"));
		softAssert.assertAll();
	}
	
	@Test
	public void createRepositoryPOJOTest() throws JsonProcessingException {
		//declaring POJO and setting the values
		requestPayload = new CreateRepoPOJO();
		requestPayload.setName("API-testing-restcall-9");
		requestPayload.setDescription("Repository created via Rest Assured Test 2");
		
		//using object mapper to to convert the POJO to a string for the payload
		objectMapper = new ObjectMapper();
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		
		//making post request and storing the response, then converting it to a string
		response = postRequest(endPoint, payload, bearer_Token);
		String responseString = response.getBody().asString();
		
		//asserting that the values passed are the same values returned
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(requestPayload.getName(), CommonUtilFunctions.getResponseKeyValue(responseString, "name"));
		softAssert.assertEquals(requestPayload.getDescription(), CommonUtilFunctions.getResponseKeyValue(responseString, "description"));
		softAssert.assertAll();
	}
	
	@Test
	public void deleteRepo() throws IOException {
		//generating the payload from the json file to use for the endpoint
		String req_Payload = payloadGenerator.generateStringPayload("createRepo.json");
		
		//generating the endpoint for deleting a repository using the name from the json file used to create the repository
		String deleteEndPoint = createURL.getBaseURI("/repos/dawg53/") + CommonUtilFunctions.getResponseKeyValue(req_Payload, "name");
		
		//making the delete request and storing the response
		response = deleteRequest(deleteEndPoint, bearer_Token);
		
		//asserting that the status code returned is 204 and successful since there is no json response for a delete
		//if the test fails then it also returns status message
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204, CommonUtilFunctions.getStatusMessage(response));
	}
	
	@Test
	public void deleteRepoPOJO() throws IOException {
		//creating the endpoint using the POJO name value from previous test
		String deleteEndPoint = createURL.getBaseURI("/repos/dawg53/") + requestPayload.getName();
		
		//making delete request and storing response
		response = deleteRequest(deleteEndPoint, bearer_Token);
		
		//asserting that the status code returned is 204 and successful since there is no json response for a delete
		//if the test fails then it also returns status message
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204, CommonUtilFunctions.getStatusMessage(response));
	}
}

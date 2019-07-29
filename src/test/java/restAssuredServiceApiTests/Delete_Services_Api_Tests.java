package restAssuredServiceApiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;
import restAssuredProductApiTests.ProductDataUtils;

public class Delete_Services_Api_Tests {

	public static HashMap map = new HashMap();
	int serviceId;
	
	//To ensure that service we wanted to delete with specific Id is available in the list,
	//We should first create a dummy service and then same service should be deleted from the list.
	@BeforeClass
	public void firstCreateNewService()
	{
		map.put("name", "Test Service Name-"+RandomStringUtils.randomAlphabetic(2));
		
		serviceId =
		given()
		.contentType("application/json")
		.body(map)
	
		.when()
			.post(BaseDataUtils.getBaseUri()+"/services")
		
		.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.log().all()
			.extract().path("id");
	}
	
	// Test API for deleting a specific service with given Id of a service (newly generate service) 
	@Test
	public void testDeleteServiceApi()
	{
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/services/" + serviceId;
		
		given()
	
		.when()
			.delete()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("id",equalTo(serviceId))
			.log().all();
	}
}

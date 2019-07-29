package restAssuredServiceApiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;

public class Get_Service_With_Id_Api_Tests {
	
	int serviceId = 3;
	
	// Test API for getting a specific service with given Id 
	@Test
	public void testGetServiceWithIdApi()
	{
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/services/" + serviceId;
		
		given()
	
		.when()
			.get()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.body("id",equalTo(serviceId))
			.body("name",equalTo("Best Buy For Business"))
			.log().all();
	}

}

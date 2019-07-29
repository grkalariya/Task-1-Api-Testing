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

public class Patch_Service_With_Id_Api_Tests {
	
	public static HashMap map = new HashMap(); 
	int serviceId = 8;
	
	// Data preparation for updating a specific service data
	@BeforeClass
	public void postdata()
	{
		map.put("name", "Test Service Name-"+RandomStringUtils.randomAlphabetic(2));
						
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/services/" + serviceId;
	}
	
	// Test API for updating a specific service data with given Id 
	@Test
	public void testUpdateServicesWithIdApi()
	{		
		given()
			.contentType("application/json")
			.body(map)
	
		.when()
			.patch()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("id",equalTo(serviceId))
			.body("name",equalTo(map.get("name")))
			.log().all();
	}

}

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

public class Post_Services_Api_Tests {
	
	public static HashMap map = new HashMap(); 
	
	@BeforeClass
	public void postdata()
	{
		map.put("name", "Test Service Name-"+RandomStringUtils.randomAlphabetic(2));
				
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/services";
	}
	
	// Create new service using Post data
	@Test
	public void testPostServiceDataApi()
	{
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
			.post()
		
		.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.body("name",equalTo(map.get("name")))
			.log().all();
			
	}

}

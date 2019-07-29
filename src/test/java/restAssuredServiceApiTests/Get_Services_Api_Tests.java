package restAssuredServiceApiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;

public class Get_Services_Api_Tests {
	
	@BeforeClass
	public void prepareData()
	{
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/services";	
	}
	
	// Test API for getting list of all the services 
	@Test
	public void testGetServicesList()
	{
		given()		
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.log().all();	
	}
	
	// Test API for getting list of services with limit	
	@Test
	public void testGetServicesListWithLimit()
	{
		given()		
			.queryParam("$limit", "4")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.body("data", hasSize(4)) //because limit=4 has been set
			.log().all();
	}
	
	// Test API for getting list of services with skip
	@Test
	public void testGetServicesListWithSkip()
	{
		given()		
			.queryParam("$skip", "2")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.log().all();	
	}
	
	// Test API for getting list of services with limit & skip
	@Test
	public void testGetServicesListWithLimitAndSkip()
	{
		given()		
			.queryParam("$limit", "4").queryParam("$skip", "2")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.body("data", hasSize(4)) //because limit=4 has been set
			.log().all();
	}

}

package restAssuredProductApiTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get_Products_Api_Tests {
	
	@BeforeClass
	public void prepareData()
	{
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/products";	
	}
	
	// Test API for getting list of all the products 
	@Test
	public void testGetProductsList()
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
	
	// Test API for getting list of products with limit	
	@Test
	public void testGetProductsListWithLimit()
	{
		given()		
			.queryParam("$limit", "3")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.body("data", hasSize(3)) //because limit=3 has been set
			.log().all();
	}
	
	// Test API for getting list of products with skip
	@Test
	public void testGetProductsListWithSkip()
	{
		given()		
			.queryParam("$skip", "5")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.log().all();	
	}
	
	// Test API for getting list of products with limit & skip
	@Test
	public void testGetProductsListWithLimitAndSkip()
	{
		given()		
			.queryParam("$limit", "3").queryParam("$skip", "5")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.body("data", hasSize(3)) //because limit=3 has been set
			.log().all();
	}



}

package restAssuredProductApiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;

public class Get_Product_With_Id_Api_Tests {
	
	int productId = 185230;
	
	// Test API for getting a specific product with given Id 
	@Test
	public void testGetProductWithIdApi()
	{
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/products/" + productId;
		
		given()
	
		.when()
			.get()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("content-type", "application/json; charset=utf-8")
			.body("id",equalTo(productId))
			.log().all();
	}

}

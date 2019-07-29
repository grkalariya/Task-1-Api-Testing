package restAssuredProductApiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;

public class Patch_Product_With_Id_Api_Tests {
	
	public static HashMap map = new HashMap(); 
	int productId = 309062;
	
	// Data preparation for updating a specific product data
	@BeforeClass
	public void postdata()
	{
		map.put("name", ProductDataUtils.getName());
		map.put("price", ProductDataUtils.getPrice());
		map.put("model", ProductDataUtils.getModel());
				
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/products/" + productId;
	}
	
	// Test API for updating a specific product data with given Id 
	@Test
	public void testUpdateProductWithIdApi()
	{		
		given()
			.contentType("application/json")
			.body(map)
	
		.when()
			.patch()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("id",equalTo(productId))
			.body("name",equalTo(map.get("name")))
			.body("price",equalTo(map.get("price")))
			.body("model",equalTo(map.get("model")))
			.log().all();
	}

}

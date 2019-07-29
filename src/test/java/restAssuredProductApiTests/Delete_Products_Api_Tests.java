package restAssuredProductApiTests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;

public class Delete_Products_Api_Tests {

	public static HashMap map = new HashMap();
	int productId;
	
	//To ensure that product we wanted to delete with specific Id is available in the list,
	//We should first create a dummy product and then same product should be deleted from the list.
	@BeforeClass
	public void firstCreateNewProduct()
	{
		map.put("name", ProductDataUtils.getName());
		map.put("type", ProductDataUtils.getType());
		map.put("price", ProductDataUtils.getPrice());
		map.put("shipping", ProductDataUtils.getShipping());
		map.put("upc", ProductDataUtils.getUpc());
		map.put("description", ProductDataUtils.getDescription());
		map.put("manufacturer", ProductDataUtils.getManufacturer());
		map.put("model", ProductDataUtils.getModel());
		map.put("url", ProductDataUtils.getUrl());
		map.put("image", ProductDataUtils.getImage());
		
		productId =
		given()
		.contentType("application/json")
		.body(map)
	
		.when()
			.post(BaseDataUtils.getBaseUri()+"/products")
		
		.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.log().all()
			.extract().path("id");
	}
	
	// Test API for deleting a specific product with given Id of a product (newly generate product) 
	@Test
	public void testDeleteProductApi()
	{
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/products/" + productId;
		
		given()
	
		.when()
			.delete()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("id",equalTo(productId))
			.log().all();
	}
}

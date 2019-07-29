package restAssuredProductApiTests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseDataForApiTests.BaseDataUtils;
import io.restassured.RestAssured;

public class Post_Products_Api_Tests {

	public static HashMap map = new HashMap(); 
	
	@BeforeClass
	public void postdata()
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
		
		RestAssured.baseURI = BaseDataUtils.getBaseUri();
		RestAssured.basePath = "/products";
	}
	
	@Test
	public void testPostProductDataApi()
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
			.body("type",equalTo(map.get("type")))
			.body("price",equalTo(map.get("price")))
			.body("shipping",equalTo(map.get("shipping")))
			.body("upc",equalTo(map.get("upc")))
			.body("description",equalTo(map.get("description")))
			.body("manufacturer",equalTo(map.get("manufacturer")))
			.body("model",equalTo(map.get("model")))
			.body("url",equalTo(map.get("url")))
			.body("image",equalTo(map.get("image")))
			.log().all();
			
	}
}

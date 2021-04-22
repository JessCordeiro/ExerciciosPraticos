package apiTeste;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ApiTest extends Data{
	
	
	
	@SuppressWarnings("unchecked")
	@Test(priority = 1, dataProvider = "DataForPost")
	public void test_post(String id, String username, String firstName, String lastName) {

		JSONObject request = new JSONObject();
		request.put("id", id);
		request.put("username", username);
		request.put("firstName", firstName);
		request.put("lastName", lastName);

		baseURI = "https://petstore.swagger.io/v2/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/user").
		then().
		statusCode(200)
		.log().all();

	}
	
	@SuppressWarnings("unchecked")
	@Test(priority = 2, dataProvider = "DataForPostDog")
	public void test_post_dog(String id, String category, String name, String status) {

		JSONObject request = new JSONObject();

		request.put("id", id);
		request.put("category", category);
		request.put("name", name);
		request.put(status, status);

		baseURI = "https://petstore.swagger.io/v2/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/pet").
		then().
		statusCode(200)
		.log().all();

	}
	
	@SuppressWarnings("unchecked")
	@Test(priority = 3, dataProvider = "DataForPostCat")
	public void test_post_cat(String id, String category, String name, String status) {

		JSONObject request = new JSONObject();

		request.put("id", id);
		request.put("category", category);
		request.put("name", name);
		request.put(status, status);

		baseURI = "https://petstore.swagger.io/v2/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/pet").
		then().
		statusCode(200)
		.log().all();

	}	

	
	@SuppressWarnings("unchecked")
	@Test(priority = 4, dataProvider = "DataForPostVendaDog")
	public void test_post_venda(String id, String petId, int quantity, String status) {

		JSONObject request = new JSONObject();

		request.put("id", id);
		request.put("petId", petId);
		request.put("quantity", quantity);
		request.put("status", status);

		baseURI = "https://petstore.swagger.io/v2/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/store/order").
		then().
		statusCode(200)
		.log().all();

	}	
	
	
}





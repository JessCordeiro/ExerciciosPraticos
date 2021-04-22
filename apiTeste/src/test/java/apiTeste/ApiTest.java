package apiTeste;

import org.junit.Test;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ApiTest {
	
	

	@Test
	public void CriandoUsuarioMariaAssuncao() {
		RestAssured.given()
		.body("{ \"id\": 1, \"username\": \"mariaAssuncao\", \"firstName\": \"Maria\", \"lastName\": \"Assunção\", \"email\": \"string\",  \"password\": \"string\",  \"phone\": \"string\", \"userStatus\": 0	}")
		.contentType(ContentType.JSON)
		
		.when()
		.post("https://petstore.swagger.io/v2/user")
		.then()
		.statusCode(200)
		;
	}
	
	
	@Test
	public void CriandoPetDog() {
		RestAssured.given()
		.body("{\"id\": 3,\"category\": {  \"id\": 0,   \"name\": \"Dog\" },  \"name\": \"Brutus\",  \"photoUrls\": [   \"string\"  ],	  \"tags\": [  {  \"id\": 1,     \"name\": \"Maria Assunção\"    }  ],  \"status\": \"delivered\"}")
		.contentType(ContentType.JSON)
		
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		.then()
		.statusCode(200)
		;
	}
	
	
	
	
	
	@Test
	public void FazendoaVendaBrutusMaria() {
		RestAssured.given()
		.body("{ \"id\": 1, \"petId\": 3, \"quantity\": 1, \"shipDate\": \"2021-04-06T01:27:49.898Z\", \"status\": \"delivered\", \"complete\": true}")
		.contentType(ContentType.JSON)
		
		.when()
		.post("https://petstore.swagger.io/v2/store/order")
		.then()
		.statusCode(200)
		;
	}
	
	
	
	
	@Test
	public void VerRequisicao() {
		RestAssured.given()
		.when()
		.get("https://petstore.swagger.io/v2/pet/3")
		.then()
		.statusCode(200)
		;
	
	}
}





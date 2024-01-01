package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	
	public static Response postUserEndPoint(User payload) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.post(Routes.post_url);
		return response;
	}
	
	public static Response getUserEndPoint(String username) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", username)
							.when()
								.get(Routes.get_url);
		return response;
	}
	
	public static Response updateUserEndPoint(User payload, String username) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
								.pathParam("username", username)
							.when()
								.put(Routes.put_url);
		return response;
	}
	
	public static Response deleteUserEndPoint(String username) {
		
		Response response = given()
								.pathParam("username", username)
							.when()
								.delete(Routes.delete_url);
		return response;
	}

}

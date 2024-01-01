package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints2 {
	
	static ResourceBundle resBundle = ResourceBundle.getBundle("routes");
	
	public static Response postUserEndPoint(User payload) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.post(resBundle.getString("post_url"));
		return response;
	}
	
	public static Response getUserEndPoint(String username) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", username)
							.when()
								.get(resBundle.getString("get_url"));
		return response;
	}
	
	public static Response updateUserEndPoint(User payload, String username) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
								.pathParam("username", username)
							.when()
								.put(resBundle.getString("put_url"));
		return response;
	}
	
	public static Response deleteUserEndPoint(String username) {
		
		Response response = given()
								.pathParam("username", username)
							.when()
								.delete(resBundle.getString("delete_url"));
		return response;
	}

}

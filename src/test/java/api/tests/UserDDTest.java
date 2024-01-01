package api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserDDTest {
	
	
	@Test(priority = 1,dataProvider="Data", dataProviderClass=api.utilities.DataProviders.class)
	void postReq(String userID, String userName, String firstName, String lastName, String email, String password, String phone) {
		
		User user = new User();
		user.setId(Integer.parseInt(userID));
		user.setUsername(userName);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		
		Response res = UserEndPoints.postUserEndPoint(user);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=api.utilities.DataProviders.class)
	void deleteReq(String userName) {
		Response res = UserEndPoints.deleteUserEndPoint(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}

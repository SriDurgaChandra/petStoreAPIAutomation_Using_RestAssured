package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	User user;
	Faker faker = new Faker();
	Logger logger;
	
	@BeforeClass
	void setupData() {
		logger = LogManager.getLogger(this.getClass());
		user = new User();
		user.setId(faker.idNumber().hashCode());
		user.setUsername(faker.name().username());
		user.setFirstname(faker.name().firstName());
		user.setLastname(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		user.setPassword(faker.internet().password());
		user.setPhone(faker.phoneNumber().phoneNumber());
	}
	
	@Test(priority=1)
	void addUserTest() {
		logger.info("**********************Adding user************************");
		Response res = UserEndPoints2.postUserEndPoint(user);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**********************Added user************************");
	}
	
	
	@Test(priority=2)
	void getUserTest() {
		logger.info("**********************Retrieve user************************");
		Response res = UserEndPoints2.getUserEndPoint(user.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("**********************fetched user************************");
	}
	
	@Test(priority=3)
	void updateUserTest() {
		logger.info("**********************updating user************************");
		user.setUsername(faker.name().username());
		user.setFirstname(faker.name().firstName());
		Response res = UserEndPoints2.updateUserEndPoint(user, this.user.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("**********************updated user************************");
	}
	
	@Test(priority=4)
	void deleteUserTest() {
		logger.info("**********************Deleting user************************");
		Response res = UserEndPoints2.deleteUserEndPoint(this.user.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("**********************Deleted user************************");
	}

}

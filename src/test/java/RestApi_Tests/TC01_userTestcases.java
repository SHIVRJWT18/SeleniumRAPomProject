package RestApi_Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestApi_Endpoints.ApiMethods;
import RestApi_Payload.UserPayloadPojo;
import RestApi_Utilities.DataSetup;
import io.restassured.response.Response;

public class TC01_userTestcases {
    ApiMethods apimthd;
	DataSetup data;
	UserPayloadPojo body1,body2;
	@BeforeClass
	public void setData()
	{
	 data = new DataSetup();	
	 apimthd = new ApiMethods();	 
	 body1 = data.setUserData();
     System.out.println("Generated User ID: " + body1.getId());
     System.out.println("Generated Username: " + body1.getUsername());
     System.out.println("Generated Email: " + body1.getEmail());
	}
	
	@Test(priority=1)
	public void testpostuser()
	{
	  Response res = apimthd.createUser(body1);	        

      res.then()
      .log().body();
     
      Assert.assertEquals(res.getStatusCode(), 200);
      
	}
	
	@Test(priority=2)
	public void testgetuser()
	{
	  Response res = apimthd.fetchUser(this.body1.getUsername());      

      res.then()
      .statusCode(200)
      .log().body();
      
      Assert.assertEquals(res.jsonPath().getString("email"),this.body1.getEmail());
    		
	}
	
	@Test(priority=3,dependsOnMethods = "testpostuser")
	public void testUpdateUser()
	{
	 body2 = data.updateUserData();
     System.out.println("Generated Updated FN: " + body2.getFirstname());
     System.out.println("Generated Updated LN: " + body2.getLastname());
	 System.out.println("Generated Updated Email: " + body2.getEmail());	
	 Response rp = apimthd.updateUser(this.body1.getUsername(), body2);	
	 rp.then().log().body();
	 
	 Assert.assertEquals(rp.getStatusCode(), 200);
	 Response getAfterUpdate = apimthd.fetchUser(this.body1.getUsername());      

	 Assert.assertEquals(getAfterUpdate.jsonPath().getString("email"), body2.getEmail());
	}
	
	@Test(priority=4)
	public void testdeleteuser()
	{
	  Response res = apimthd.deleteUser(this.body1.getUsername());      

      res.then()
      .statusCode(200)
      .log().body();
 		
	}
}


package RestApi_Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestApi_Endpoints.ApiMethods;
import RestApi_Payload.UserPayloadPojo;
import RestApi_TestData.ExcelDataProviders;

import io.restassured.response.Response;

public class TC02_userDataDrivenTestcases {

    ApiMethods apimthd;
    ExcelDataProviders exceldata;

    @BeforeClass
    public void setData() {
    apimthd = new ApiMethods();
    }

    @Test(priority = 1,dataProvider = "TestingAllData",
    		dataProviderClass = ExcelDataProviders.class )
    public void testpostuser(UserPayloadPojo body1) {
        Response res = apimthd.createUser(body1);
        res.then().log().body();
        System.out.println("Created Username: " + body1.getUsername());
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    

    @Test(
        priority = 2,
        dataProvider = "TestingUsernamesData",
        dataProviderClass = ExcelDataProviders.class ,
        enabled = true
    )
    public void testdeleteuser(String username) {

        Response res = apimthd.deleteUser(username);

        res.then()
           .statusCode(200) 
           .log().body();
        System.out.println("Deleted Username: " + username);

    }
}

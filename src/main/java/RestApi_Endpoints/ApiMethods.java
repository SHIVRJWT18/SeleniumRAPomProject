package RestApi_Endpoints;
import static io.restassured.RestAssured.given;

import RestApi_Payload.UserPayloadPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created to perform CRUD operations on API
public class ApiMethods {

	public Response createUser(UserPayloadPojo payload)
	{
	 	Response resp = given()
	 	  .contentType(ContentType.JSON)
	 	  .accept(ContentType.JSON)
	 	  .body(payload)
	     .when()
	       .post(ApiRoutes.UM_posturl);	
	 	return resp;
	}
	
	public Response fetchUser(String usrname)
	{
	 	Response resp = given()
	 	  .pathParam("username", usrname)
	     .when()
	       .get(ApiRoutes.UM_geturl);	
	 	return resp;
	}
	
	public Response updateUser(String updtuser, UserPayloadPojo payload)
	{
	 	Response resp = given()
	 	  .contentType(ContentType.JSON)
	 	  .accept(ContentType.JSON)
	 	  .pathParam("username", updtuser)
	 	  .body(payload)
	     .when()
	       .put(ApiRoutes.UM_updateurl);	
	 	return resp;
	}
	
	public Response deleteUser(String delusrname)
	{
	 	Response resp = given()
	 	  .pathParam("username", delusrname)
	     .when()
	       .get(ApiRoutes.UM_deleteurl);	
	 	return resp;
	}
	
}

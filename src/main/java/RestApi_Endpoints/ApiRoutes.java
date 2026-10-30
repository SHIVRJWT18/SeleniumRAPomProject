package RestApi_Endpoints;

/**
 * Swager File: https://petstore.swagger.io
 * Create User(Post): https://petstore.swagger.io/v2/user
 * Get User(Get): https://petstore.swagger.io/v2/user/{username}
 * Update User(Put): https://petstore.swagger.io/v2/user/{username}
 * Delete User(Delete):  https://petstore.swagger.io/v2/user/{username}
 */
public class ApiRoutes {

	public static String baseurl = "https://petstore.swagger.io/v2"; 
    
	// User Module
	public static String UM_posturl = baseurl+"/user";
	public static String UM_geturl = baseurl+"/user/{username}";
	public static String UM_updateurl = baseurl+"/user/{username}";
	public static String UM_deleteurl = baseurl+"/user/{username}";

	//Store Module
	public static String SM_posturl = baseurl+"/store/order";
	public static String SM_geturl = baseurl+"/store/order/{orderId}";
	public static String SM_getinventory = baseurl+"/store/inventory";
	public static String SM_deleteurl = baseurl+"/store/order/{orderId}";
	
	// Pet Module
    public static String PM_posturl = baseurl + "/pet";
    public static String PM_geturl = baseurl + "/pet/{petId}";
    public static String PM_updateurl = baseurl + "/pet";
    public static String PM_deleteurl = baseurl + "/pet/{petId}";
}

package RestApi_TestData;

import CommonProjectUtiliites.ExcelUtility;
import RestApi_Payload.UserPayloadPojo;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;
public class ExcelDataProviders {
	UserPayloadPojo userPyload;
	ExcelUtility exc;
    @DataProvider(name = "TestingAllData")
    public String[][] getAllDataFromExcel() {
       String path = "E:\\SHIV SCRIPTS\\TestData\\ApiExcelTest.xlsx";
       exc = new ExcelUtility(path);
       int rownum = exc.getRowCount("Sheet1");
       int colcount = exc.getCellCount("Sheet1", 0);
       String[][] apidata = new String[rownum - 1][colcount];
       for (int i = 1; i < rownum; i++) 
       {	   
    	for (int j = 0; j < colcount; j++) {
         apidata[i - 1][j] = exc.getCellData("Sheet1", i, j);
        }
       }
        return apidata;
      }

    @DataProvider(name = "TestingUsernamesData")
    public String[] getUsernamesFromExcel() {
        String path = "E:\\SHIV SCRIPTS\\TestData\\ApiExcelTest.xlsx";
        exc = new ExcelUtility(path);
        int rownum = exc.getRowCount("Sheet2");
        String[] usernames = new String[rownum - 1];
        for (int i = 1; i < rownum; i++) {
            usernames[i - 1] = exc.getCellData("Sheet2", i, 0);
        }
        return usernames;
    }
    
	public UserPayloadPojo setUserData(
	       String uid, String uname, String fname, String lname, String uemail, 
		   String upswd,String uphone) {
     
     userPyload = new UserPayloadPojo();		
     userPyload.setId(Integer.parseInt(uid));
     userPyload.setUsername(uname);
     userPyload.setFirstname(fname);
     userPyload.setLastname(lname);
     userPyload.setEmail(uemail);
     userPyload.setPassword(upswd);
     userPyload.setPhone(uphone);
	 return userPyload;
	}
	
	public String fetchUserNameFromExcel(String uname) {

	    return uname;
	}
    
}

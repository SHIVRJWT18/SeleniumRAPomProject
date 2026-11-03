package RestApi_TestData;

import CommonProjectUtiliites.ExcelUtility;
import RestApi_Payload.UserPayloadPojo;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

/**Loop iteration Excel row index (i) Array index (i-1)
        1	               1	       0
        2                  2	       1
        3	               3	       2
*/
public class ExcelDataProviders {
	UserPayloadPojo userPyload;
	ExcelUtility exc;
    @DataProvider(name = "TestingAllData")
    public Object[][] getAllDataFromExcel() {
       String path = "E:\\SHIV SCRIPTS\\TestData\\ApiExcelTest.xlsx";
       exc = new ExcelUtility(path);
       int rownum = exc.getRowCount("Sheet1");
       System.out.println("Total Rows: " + rownum);
       Object[][] apidata = new Object[rownum][1];
       for (int i = 1; i <= rownum; i++) 
       {	   
    	userPyload = new UserPayloadPojo();
    	userPyload.setId(Integer.parseInt(exc.getCellData("Sheet1", i, 0)));
    	userPyload.setUsername(exc.getCellData("Sheet1", i, 1));
    	userPyload.setFirstname(exc.getCellData("Sheet1", i, 2));	
    	userPyload.setLastname(exc.getCellData("Sheet1", i, 3));
    		
    	userPyload.setEmail(exc.getCellData("Sheet1", i, 4));
    	userPyload.setPhone(exc.getCellData("Sheet1", i, 5));	
    	apidata[i-1][0] = userPyload;
    	   
       }
        return apidata;
      }

    @DataProvider(name = "TestingUsernamesData")
    public String[] getUsernamesFromExcel() {
        String path = "E:\\SHIV SCRIPTS\\TestData\\ApiExcelTest.xlsx";
        exc = new ExcelUtility(path);
        int rownum = exc.getRowCount("Sheet2");
        System.out.println("Total Rows: " + rownum);
        String[] usernames = new String[rownum];
        for (int i = 1; i <= rownum; i++) {
            usernames[i-1] = exc.getCellData("Sheet2", i, 0);
        }
        return usernames;
    }
    

	
	public String fetchUserNameFromExcel(String uname) {

	    return uname;
	}
    
}

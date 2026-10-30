package RestApi_Utilities;

import com.github.javafaker.Faker;
import RestApi_Payload.UserPayloadPojo;
public class DataSetup {

	Faker fak;
	UserPayloadPojo userpojo;
	public UserPayloadPojo setUserData()
	{
     fak = new Faker();	
     userpojo = new UserPayloadPojo();
		
     userpojo.setId(fak.idNumber().hashCode());
     userpojo.setUsername(fak.name().username());
     userpojo.setFirstname(fak.name().firstName());
     userpojo.setLastname(fak.name().lastName());
     userpojo.setEmail(fak.internet().safeEmailAddress());
     userpojo.setPassword(fak.internet().password(5, 10));
     userpojo.setPhone(fak.phoneNumber().cellPhone());
	 return userpojo;
	}
	
	public UserPayloadPojo updateUserData()
	{
	 userpojo.setFirstname(fak.name().firstName());
	 userpojo.setLastname(fak.name().lastName());
	 userpojo.setEmail(fak.internet().safeEmailAddress());
	 return userpojo;
	}
}

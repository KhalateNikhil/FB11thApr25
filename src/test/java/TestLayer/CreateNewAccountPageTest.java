package TestLayer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.CreateNewAccountPage;

public class CreateNewAccountPageTest extends BaseClass{
	private static CreateNewAccountPage createnewaccountpage;
	@BeforeTest
	public void setUp()
	{
		BaseClass.initialization();
	}

	
	@Test
	public void validatecreateNewUser()
	{
		 createnewaccountpage= new CreateNewAccountPage();
		 createnewaccountpage.createNewUserFunctionality("Nikhil", "khalate", "nk@gmail.com", "nsk@123", "6", "Apr", "1999", "Male");
	}

	@AfterTest
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

	
	}


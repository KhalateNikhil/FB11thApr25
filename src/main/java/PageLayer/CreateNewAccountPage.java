package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.Wait;

public class CreateNewAccountPage extends BaseClass{
	
	
	@FindBy(name="firstname")
	private WebElement firstname ;
	
	
	@FindBy(name="lastname")
	private WebElement  lastname;

	@FindBy(name="reg_email__")
	private WebElement email ;

	@FindBy(name="reg_passwd__")
	private WebElement pass  ;

	@FindBy(name="birthday_day")
	private WebElement  bday;

	@FindBy(name="birthday_month")
	private WebElement  bmonth;

	@FindBy(name="birthday_year")
	private WebElement byear ;
	
	@FindBys(@FindBy(xpath="//span[@class='_5k_2 _5dba']"))
	private List<WebElement> gender;

	
	//now initialize OR by using PageFactory.initElements method in constructor
	
	
	public CreateNewAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//create associated methods for each and every OR without passing test data
	
	public void createNewUserFunctionality(String fname, String lname,String Email,String password,String day,String month,String year,String Gender) 
	{
		Wait.sendKeys(firstname, fname);
		Wait.sendKeys(lastname, lname);
		Wait.sendKeys(email, Email);
		Wait.sendKeys(pass, password);
		HandleDropDown.selectByVisibleText(bday, day);
		HandleDropDown.selectByVisibleText(bmonth, month);
		HandleDropDown.selectByVisibleText(byear, year);
		Wait.selectAnyOption(gender, Gender);
		System.out.println("TC 1 added by Nikhil Dada");
	}
	
	
	
	
	


}

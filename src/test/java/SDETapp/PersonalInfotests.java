package SDETapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

//Test case #001:
// TC Description: full name must be mandatory
// 1. Given I am on SDET JOb application page
// 2. When I do not proviede full name information
// 3. and i click next
// 4. then error message "Enter a value for this field."
//       should be displayed

// you are assigned to test a user story:
//what steps you take to test and automate it
/*
 * 1. analyze user story
 * 2. wrote test based on positive or negative scenarios
 * 3. manually test it
 * 4. if no bugs then start automation else log the defect
 * and reject automation
 * 
 * Story >
 *  */
public class PersonalInfotests {
	Faker faker = new Faker();	
	WebDriver driver;
	String url ="https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ";
	String email = faker.name().firstName() + "@yahoo.com";


	@BeforeMethod
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		

}

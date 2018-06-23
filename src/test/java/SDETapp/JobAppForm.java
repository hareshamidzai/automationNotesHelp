package SDETapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JobAppForm {
Faker faker = new Faker();	
WebDriver driver;
String url ="https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ";
String email = faker.name().firstName() + "@yahoo.com";


@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void FillApp() {
	
		driver.get(url);
	String name1 = faker.name().firstName();
	String LastName = faker.name().lastName();
	driver.findElement(By.name("Name_First")).sendKeys(name1 + Keys.ENTER +
		LastName)	;
	

}}

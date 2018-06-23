package SDETapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalInformationTests {
	WebDriver driver;
	
	@BeforeClass// funs befor each class
        public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//implicit wait needs to set up only once in the beginning and it 
		// applies for all selenium steps.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	driver.manage().window().fullscreen();
		}
	@BeforeMethod //runs before each at test
	public void navigateToHomePage() {
		System.out.println("Navigating to Page in @Before Method");
		driver.get("https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
		
	}
	@Test
	public void fullNameemptyTest() {
		//firstly assert that you are on the correct page
		// use assert import static org.testng.Assert.*;
		assertEquals(driver.getTitle(),"SDET Job Application");
		
		driver.findElement(By.xpath("//input[@name='Name_First']")).clear();
		
	//	<input type="text" maxlength="255" elname="last"
//		name="Name_Last" value="" invlovedinsalesiq="false">
		
		driver.findElement(By.xpath("//em[.=' Next ']")).click();
		
//		<p class="errorMessage" elname="error" id="error-Name" 
//		style="display: block;">Enter a value for this field.</p>
		
	String nameError =	driver.findElement(By.xpath("//p[@id='error-Name']")).getText();
		assertEquals(nameError, "Enter a value for this field.");
	}

}

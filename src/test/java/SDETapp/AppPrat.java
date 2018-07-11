package SDETapp;

import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppPrat {

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
		public void Names() throws InterruptedException {
			driver.get(url);
		//	"//input[@elname='first']"
	//		driver.findElement(By.xpath("//input[@name='Name_First']")).sendKeys("works");
			
	WebElement names = driver.findElement(By.xpath("//input[@name='Name_First']"));
	names.sendKeys(faker.name().firstName()+Keys.TAB+faker.name().lastName());
//		driver.close();
//			
//			
//	}
//		@Test
//		public void Gender() {
//			driver.get(url);
			WebElement gender = driver.findElement(By.xpath("//input[@id='Radio_1']"));
			gender.isSelected();
			gender.click();
			WebElement FGender = driver.findElement(By.xpath("//input[@id='Radio_2']"));
			FGender.isDisplayed();
	        FGender.isSelected();
	        String Gen = FGender.getAttribute("Value");
	        assertEquals(Gen,"Female");
	        System.out.println(Gen);
	        Thread.sleep(300);
			FGender.click();
			Thread.sleep(300);
			gender.click();
			
			
			
	}
		
		   //  @AfterClass
	      public void tearDown() {
	         driver.close();
	      }
	
	
}

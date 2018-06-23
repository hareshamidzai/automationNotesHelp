package SDETapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalInformationTests {
	WebDriver driver;
	String firstName;
	String lastName;
	int gender;
	String dateOfBirth;
	String email;
	String phoneNumber;
	String city;
	String state;
	String country;
	int annuaSalary;
	List<String> technologies;
	int yearsOfExperience;
	int education;
	String github;
	List<String> certifications;
	String additionalSkills;
	Faker faker = new Faker();
	Random random = new Random();
	 double annualSalary;
	
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
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		gender = new Random().nextInt(2)+1;
		dateOfBirth = faker.date().birthday().toString();
		email = "murodil_ruz@yahoo.com";
		phoneNumber= faker.phoneNumber().cellPhone();
		city= faker.address().cityName();
		state = faker.address().stateAbbr();
		country= faker.address().country();
		annualSalary = faker.number().numberBetween(60000, 150000);
		technologies = new ArrayList<>();
		technologies.add("Java-" +faker.number().numberBetween(1, 4));
		technologies.add("HTML-"+faker.number().numberBetween(1, 4));
		
		yearsOfExperience = faker.number().numberBetween(0, 10);
		education = faker.number().numberBetween(1, 4);
		github = "https://github.com/CyberteckSchool/selenium";
		certifications = new ArrayList<>();
		
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

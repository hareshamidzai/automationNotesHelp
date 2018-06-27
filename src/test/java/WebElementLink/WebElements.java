package WebElementLink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {

	WebDriver driver;


	@BeforeClass //runs once for all tests
	public void setUp() {

		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test  //List<WebElement> links = driver.findElements(By.tagName("a"));
	public void myLinks() {
		driver.get("https://github.com");
		// got to page and find all the elements that are links
	                                              //By.xpath("//a"));	
		List<WebElement> links = driver.findElements(By.tagName("a"));
	//	List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		int numberOfLinksOnGithub = links.size();
		System.out.println("number of links: "+ numberOfLinksOnGithub);
        //print text of each link
		for(WebElement link : links ) {
			// check to see if it is Empty
			if(!link.getText().isEmpty()) {
			System.out.println(link.getText());
			
			}
		}
		// add each link text into a list of Strings
		List<String> linkNames = new ArrayList<>();
		
		for(WebElement link : links) {
			if(!link.getText().isEmpty()) {
				linkNames.add(link.getText());
			}
		}
		
		System.out.println(linkNames.toString());
		
		
		
	}
	}
	


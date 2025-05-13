package SeleniumLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasicLocators {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		//driver.get("https://demo.opencart.com.gr/");
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		//locator - name
		//driver.findElement(By.name("search")).sendKeys("Automation Testing");
		
		//locator - id
		/*
		boolean displayed = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println((displayed)? "The Logo is Diplayed!" : "Not Displayed !!");
			//Naukri
		driver.findElement(By.id("login_Layer")).click(); 
		*/
		
		//locator - linktext and partial_linktext
		/*
		driver.findElement(By.linkText("Software")).click();
		driver.findElement(By.partialLinkText("ware")).click();
			//Naukri
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.partialLinkText("gin")).click()
		*/
		
		
		//locator - className
		/*
		List <WebElement> Elements = driver.findElements(By.className("container"));
		System.out.println(Elements.size());
		
		for(WebElement element : Elements) {
			System.out.println(element);
		}
		
			//Naukri
		driver.findElement(By.className("suggestor-input")).sendKeys("AutomationTesting");
		driver.findElement(By.className("qsbSubmit")).click();
		*/
		
		//locator - tagName
		/*
		List<WebElement> Elements = driver.findElements(By.tagName("img"));
		List<WebElement> Elementss = driver.findElements(By.tagName("a"));
		
		System.out.println(Elements.size());
		System.out.println(Elementss.size());
		
		for(WebElement element : Elements) {
			System.out.println(element);
		}
		*/
	
		
		//	driver.quit();
	}

}

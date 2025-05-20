package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Relative_Locators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement Email = driver.findElement(RelativeLocator.with(By.id("email")));
		
		//above
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(Email)).sendKeys("Gowri Shankar");
		
		//below
		//driver.findElement(RelativeLocator.with(By.tagName("input")).below(Email)).sendKeys("90000");
		
		//near should be under 50px
		driver.findElement(RelativeLocator.with(By.xpath("//input[@id='phone']")).near(Email)).sendKeys("9000er");
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		
		//toRightOf
		driver.findElement(RelativeLocator.with(By.xpath("//input[@id='input1']")).above(By.xpath("//input[@id='input2']"))).sendKeys("GOwri Shankar");
		

	}

}

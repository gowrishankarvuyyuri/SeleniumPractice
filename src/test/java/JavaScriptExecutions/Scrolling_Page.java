package JavaScriptExecutions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling_Page {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//through pixel
		js.executeScript("window.scrollBy(0, 1000)");
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, -1000)"); //js.executeScript("window.scrollBy(1000, -1000)")
		System.out.println(js.executeScript("return window.pageYOffset"));
		
		
		//through element
		WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Web Table']"));
		//js.executeScript("arguments[0].scrollIntoView(true)", element); // appears at page start
		js.executeScript("arguments[0].scrollIntoView(false)", element); //appers at page ends
		
		
		//till end of the page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		
		//till initial page
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		
	}
}

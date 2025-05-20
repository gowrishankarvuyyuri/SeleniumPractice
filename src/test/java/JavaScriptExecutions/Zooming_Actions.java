package JavaScriptExecutions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zooming_Actions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver(); 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		js.executeScript("window.document.body.style.zoom='125%'");
		
		js.executeScript("window.document.body.style.zoom='25%'");
	}

}

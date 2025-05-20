package JavaScriptExecutions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteScript_Method {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		/*
		ChromeDriver driver = new ChromDriver();
		JavascriptExecutor js = driver; 
		*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		//sending value action
		WebElement name_field = driver.findElement(By.xpath("//input[@id='name']"));
		js.executeScript("arguments[0].setAttribute('value', 'Gowri Shankar')", name_field);
		js.executeScript("arguments[0].value='test'", name_field);

		//clicking action
		WebElement radio_btn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radio_btn);

		//clearing the text in input field
		js.executeScript("arguments[0].value = \"\" ", name_field);

		//getting title of the page
		String title = (String) js.executeScript("return document.title");
		System.out.println(title);
		
		//retreiving value from input
		String field = (String) js.executeScript("return arguments[0].getAttribute('value')", name_field);
		System.out.println(field);
		
		//opening new tan
		js.executeScript("window.open('https://testautomationpractice.blogspot.com/', '_blank')");
		
		Thread.sleep(5000);
		//refreshing the page
		js.executeScript("history.go(0)");
		
	}

}

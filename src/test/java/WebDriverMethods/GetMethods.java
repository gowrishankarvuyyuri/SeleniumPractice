package WebDriverMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//.get(url)
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//.getTitle()
		String title = driver.getTitle();
		//System.out.println("Title of the WebPage: "+title);
		
		//.getCurrentUrl()
		title = driver.getCurrentUrl();
		//System.out.println("Current Url: "+title);
		
		//.getPageSource()
		title = driver.getPageSource();
		//System.out.println("Page Source: "+title);
		
		//.getWindowHandle() -- retuns unique ID of single browser window
		String handle = driver.getWindowHandle();
		System.out.println("Main Window Id: "+handle);
		
		//.getWuindowHandles() -- returns unique ID's of all browser window
		driver.findElement(By.xpath("//a[contains(text(),'Orange')]")).click();	
		Set<String> windowsID = driver.getWindowHandles();
		System.out.println(windowsID);
		
		driver.quit();
	}

}

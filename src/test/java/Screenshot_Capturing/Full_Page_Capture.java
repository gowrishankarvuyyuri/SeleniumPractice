package Screenshot_Capturing;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Full_Page_Capture {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		TakesScreenshot ts = (TakesScreenshot) driver;
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Static Web Table']"));
		js.executeScript("arguments[0].scrollIntoView()", element);
		Thread.sleep(3000);
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\fullpage.png");
		
		source.renameTo(target);
		
		driver.close();
	}

}

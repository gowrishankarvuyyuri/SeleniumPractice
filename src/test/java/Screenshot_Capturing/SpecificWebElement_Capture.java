package Screenshot_Capturing;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificWebElement_Capture {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Upload Files']"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		
		File source =  element.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\webElement.png");
		
		source.renameTo(target);
		
		driver.close();

	}

}

package WebDriverMethods.SwitchTo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_NestedFrames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//frame1 
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_2.html']")); //finding frameWebElement
		
		driver.switchTo().frame(frame1); //switching to frame
		
		driver.findElement(By.xpath("//input[@type='text'][@name='mytext2']")).sendKeys("Gowri Shankar"); // finding element in external page
		
		driver.switchTo().defaultContent();// setting back to main page
		
		
		//frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		
		driver.switchTo().frame(frame2);
		
		driver.findElement(By.xpath("//input[@type='text'][@name='mytext3']")).sendKeys("Gowri Shankar");
		
		//switching to innerframe
		WebElement inner_frame2 = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
		
		driver.switchTo().frame(inner_frame2);
		
		//using JavascriptExecutor for not getting ElementNotInterceptable exceptions
		WebElement element = driver.findElement(By.xpath("//div[@id='i9']//div[@class='rseUEf nQOrEb']"));
		
		//javascript executor will check
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
		List<WebElement> Elements = driver.findElements(By.xpath("//div[@class='Y6Myld']/div[@role='list']//div[@class='uVccjd aiSeRd FXLARc wGQFbe BJHAP oLlshd']"));
		
		//selecting mutiple options through java script executor
		for(int i=0; i < Elements.size(); i++) {
			if(i == 1 || i == 2) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click();", Elements.get(i)); // --- clicking the input box
				//jse.executeScript("arguments[0].value='';", Elements.get(i); --- clear the value in input box
			}
			else 
				continue;
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		driver.switchTo().defaultContent();
		
		
		//Normal Execution
		/*
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='rseUEf nQOrEb']")).click();
		
		List<WebElement> Elements = driver.findElements(By.xpath("//div[@class='Y6Myld']/div[@role='list']//div[@class='uVccjd aiSeRd FXLARc wGQFbe BJHAP oLlshd']"));
		
		for(int i=0; i < Elements.size(); i++) {
			if(i == 1 || i == 2)
				Elements.get(i).click();
			else
				continue;
		}
		*/
	}

}

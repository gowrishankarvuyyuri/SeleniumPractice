package Mouse_Acions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_DoubleClick {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Gowri Shankar");
		
		WebElement double_click = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		new Actions(driver).doubleClick(double_click).perform();
		
		String field2 = driver.findElement(By.xpath("//input[@id='field1']")).getAttribute("value");
		
		if(field2.equals("Gowri Shankar"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}

}

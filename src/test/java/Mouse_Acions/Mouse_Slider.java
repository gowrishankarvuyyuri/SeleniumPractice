package Mouse_Acions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Slider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		WebElement x_start =driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		WebElement x_end = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
		
		int x_st = x_start.getLocation().getX();//846
		int x_en = x_end.getLocation().getX();//976
		
		
		new Actions(driver).dragAndDropBy(x_start, 50, 0).perform();
		new Actions(driver).dragAndDropBy(x_end, -50, 0).perform();
		
		
	}

}

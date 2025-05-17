package RadioButtons_CheckBoxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> Elements = driver.findElements(By.xpath("//input[@class='form-check-input' and @type = 'radio']"));
		
		Elements.get(0).click();
		
		Thread.sleep(3000);
		
		if( Elements.get(0).isSelected())
			Elements.get(1).click();
		
		driver.close();
		
		
	}

}

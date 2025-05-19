package Mouse_Acions.KeyBoard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoard_Actions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://textcompare.com/");
		
		WebElement input = driver.findElement(By.xpath("//textarea[@name='frm_compare_1']"));
		input.sendKeys("Gowri Shankar");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(input).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		WebElement click = driver.findElement(By.xpath("//input[@value='Compare']"));
		
		action.moveToElement(click).click().perform();
	}

}

package Mouse_Acions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_RightClick {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement click = driver.findElement(By.xpath("//span[text() = 'right click me']"));

		Actions action = new Actions(driver);
		
		//standard
		action.contextClick(click).perform();
		
		//performing actions
		WebElement copy = driver.findElement(By.xpath("//span[text() = 'Copy']"));
		action.moveToElement(copy).click().perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//mouse hover with contextClick
		action.moveToElement(click).pause(Duration.ofSeconds(2)).contextClick().moveToElement(copy).click().perform();
		alert.accept();
	}

}

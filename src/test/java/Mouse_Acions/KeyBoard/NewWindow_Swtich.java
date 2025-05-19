package Mouse_Acions.KeyBoard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewWindow_Swtich {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='PlaywrightPractice']"));
		
		Actions action = new Actions(driver);
		
		//action.moveToElement(element).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).perform();
		
		List<String> windows = new ArrayList<>(driver.getWindowHandles());
		Thread.sleep(3000);
		driver.switchTo().window(windows.get(1));
		driver.close();
		
		driver.switchTo().window(windows.get(0));
		
		String Name = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']")).getText();
		System.out.println(Name);
		driver.close();
	}

}

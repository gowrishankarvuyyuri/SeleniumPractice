package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive_DropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		driver.findElement(By.cssSelector(".suggestor-input[placeholder=\"Enter skills / designations / companies\"]")).sendKeys("Selenium");
		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='layer-wrap']//div[@class='opt  ']"));
		Thread.sleep(3000);
		
		for(WebElement element : elements) {
			String suggest = element.getText();
			System.out.println(suggest);
			if(suggest.equals("Selenium")) {
				element.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[contains(.,'Search') and @class='qsbSubmit']")).click();
		

	}
}

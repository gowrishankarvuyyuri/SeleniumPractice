package WebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_with_Pagining {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));
		
		int count = 1;
		for(WebElement element : elements) {
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+count+"]/a")).click();
			count+=1;
			
			List<WebElement> Elements = driver.findElements(By.xpath("//table[@id='productTable']//tbody//input"));
			int button = 1;
			
			for(WebElement Element : Elements) {
				
				driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+button+"]//input")).click();
				button+=1;
			}
		}
	}
}

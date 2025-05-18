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
		
		//collecting number of paginations
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));
		
		int count = 1;
		
		/* selecting all clicks
		//iterating them
		for(WebElement element : elements) {
			//clicking them individually
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+count+"]/a")).click();
			count+=1;
			
			//perform actions in individual pagining	
			List<WebElement> Elements = driver.findElements(By.xpath("//table[@id='productTable']//tbody//input"));
			int button = 1;
			
			for(WebElement Element : Elements) {
				//selecting them
				driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+button+"]//input")).click();
				button+=1;
			}
		}
		*/
		
		//selecting individual clicks
		int flag = 0;
		for(WebElement element : elements) {
			//clicking them individually
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+count+"]/a")).click();
			count+=1;
			
			//perform actions in individual pagining	
			List<WebElement> Elements = driver.findElements(By.xpath("//table[@id='productTable']//tbody//td[2]"));
			int button = 1;
			
			for(WebElement Element : Elements) {
				//selecting them
				WebElement indiv = driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+button+"]/td[2]"));
				String Name = indiv.getText();
				System.out.println(Name);
				
				if(Name.equals("Television") || Name.equals("Digital Camera")) {
					driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+button+"]/td[4]/input")).click();
				}
				else {
					button+=1;
					continue;
				}
			}
			
			if(flag == 1)
				break;
		}
	}
}

package WebDriverMethods.SwitchTo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_Windows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
		driver.findElement(By.cssSelector(".wikipedia-search-button")).click();
		
		//storing n number for links to a List using FindElements
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/child::div"));
		
		System.out.println(elements.size());
		
		//clicks all links
		/*
		for(int i=1; i<=5; i++) {
			WebElement link = driver.findElement(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/child::div['+i+']"));
			link.click();
		}
		*/
		
		for(WebElement link : elements) {
			link.click();
		}
		
		//store n number of window ID's into a Set
		Set<String> WIds = driver.getWindowHandles();
		
		//converting them to a list for retreiving elements faster using .get
		List<String> Ids = new ArrayList<>(WIds);
		String parentID = Ids.get(0);
		
		//switching methods to driver to switch from one window to other
		for(String Id : Ids) {
			String title = driver.switchTo().window(Id).getTitle();
			System.out.println(title);
			if(title.equals("Selenium - Wikipedia") || title.equals("Selenium dioxide - Wikipedia")) {
				driver.close();
			}
			else
				continue;
		}
		
		//redirecting to parent window
		driver.switchTo().window(parentID);
		driver.close();
	}

}

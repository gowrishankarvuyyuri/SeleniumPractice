package WebTables;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Static_WebTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://blazedemo.com/");
		
		//selecting onboarding point
		WebElement dropdown = driver.findElement(By.name("fromPort"));
		Select dropdown_btn = new Select(dropdown);
		dropdown_btn.selectByVisibleText("Philadelphia");
		
		//selecting departing point
		WebElement dropdown2 = driver.findElement(By.name("toPort"));
		Select dropdown2_btn = new Select(dropdown2);
		dropdown2_btn.selectByVisibleText("London");
		
		driver.findElement(By.cssSelector("[value=\"Find Flights\"]")).click();
		
		//gettting all list of prices
		List<WebElement> prices = driver.findElements(By.xpath("//table//tr/td[6]"));
		
		List<String> prc = new ArrayList<>();
		
		//storing those strings into new ArrayList
		for(WebElement price : prices) {
			String extract = price.getText();
			prc.add(extract);
		}
		
		//sorting and finding min through collections
		Collections.sort(prc);
		String min_value = Collections.min(prc);
		
		//clicking flight which has min price by comparing
		int count=1;
		for(WebElement price : prices) {
			String extract = price.getText();
			count+=1;
			if(min_value.trim().equals(extract)) {
				driver.findElement(By.xpath("//table[@class='table']//td/input")).click();
				break;
			}
		}
		
		//giving required details
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Gowri Shankar");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Penumantra");
		
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='cardType']"));
		Select dropdown3_btn = new Select(dropdown3);
		dropdown3_btn.selectByVisibleText("American Express");
		
		driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
		driver.findElement(By.cssSelector("[value=\"Purchase Flight\"]")).click();
		
		//checking whether flight got booked or not !!
		String Message = driver.findElement(By.xpath("//div[@class='container hero-unit']/h1")).getText();
		
		System.out.println("Booking Sucessfull!!   " + Message);
	}

}

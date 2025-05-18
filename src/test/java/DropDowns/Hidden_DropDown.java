package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 We cannot inspect the webelements in the page, we have a two option to consider here,
 1 -> go with selector's Hub and enable Turn on Debugger, which pause the page and collect all the webelements
 2-> go with Dev Tools - Event Listners, upon select the dropdown had to navigate the blur and remove it in EventListners
 */

public class Hidden_DropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]")).click();
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		
		//through looping
		for(WebElement element : elements) {
			String name = element.getText();
			if(name.equals("Content Specialist")) 
				element.click();
		}
		
		//single selecting
		//driver.findElement(By.xpath("//div/span[text()='Automaton Tester']")).click();
		
		
	}

}

package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrap_DropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List <WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//input"));
		
		for(WebElement opt : options) {
			opt.click();
		}
		
		for(WebElement opt : options) {
			String value = opt.getAttribute("value");
			if(value.equals("HTML") || value.equals("CSS"))
				opt.click();
		}
		
		driver.findElement(By.xpath("//input[contains(@value,'Java')]")).click();
		
		System.out.println(options.size());
	}

}

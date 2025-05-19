package DatePickers_Calender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DummyTicket_Practice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#datepicker")).click();
		
		DatePicker1.datepicker1(driver, "8", "July", 2025);
	}

}

/*
 while(true) {
 
 	Month expected = convertMonth(month);
 	Month required = convertMonth(month);
 	
 	int result = expected.compareTo(required);
 	
 	if(result < 0)
 		click 'Prev'
 	else if(result > 0) 
 		clicl 'Next'
 	else 
 		break
  }
 */

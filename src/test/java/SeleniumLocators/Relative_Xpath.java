package SeleniumLocators;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Relative_Xpath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		//single attribute
		/*
		 
		//Relative Xpath
		driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter location']")).sendKeys("Hyderabad");
		
		//Absolute Xpath
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/a[1]")).click();
		*/
		
		//mutiple attributes
		/*
		driver.findElement(By.xpath("//a[@title='Jobseeker Register'][contains(@data-ga-track,'Main')]")).click();
		driver.findElement(By.xpath("//input[@class='suggestor-input '][@placeholder='Enter skills / designations / companies']")).sendKeys("Selenium");
		*/
		
		//Operators (and & or)
		/*
		driver.findElement(By.xpath("//input[@class='suggestor-input ' and contains(@placeholder,'skills')]")).sendKeys("Selenium Automation");
		driver.findElement(By.xpath("//input[@class='suggestor-input ' or starts-with(@placeholder,'Enter')]")).sendKeys("Selenium Automation");
		*/
		
		//InnerText
		/*
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Search']")).getText());
		driver.findElement(By.xpath("//div[text()='Search']")).click();
		*/
		
		//contains
		/*
		driver.findElement(By.xpath("//input[contains(@placeholder,'skills')]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//a[contains(@id,'Layer') and contains(@title,'Login')]")).click();
		*/
		
		//starts-with
		/*
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Enter')]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//a[starts-with(@title,'Job') and starts-with(@id,'login')]")).click();
		*/
		
		//chained Xpath
		/*
		driver.findElement(By.xpath("//div[@class='qsbWrapper']//input[@placeholder='Enter skills / designations / companies']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//div[@id='root']//div[contains(@class,'wrapper')]//a[contains(@title,'Jobseeker Login')]")).click();
		*/
		
		//handling WebElements Dynamically
		/*
		driver.findElement(By.xpath("//a[@id='ModeWhite' or @id='ModeDark']"));
		driver.findElement(By.xpath("//a[contains(@id,'White') or contains(@id,'Dark')]"));
		driver.findElement(By.xpath("//a[starts-with(@id,'Mode')]");
		*/
	}

}

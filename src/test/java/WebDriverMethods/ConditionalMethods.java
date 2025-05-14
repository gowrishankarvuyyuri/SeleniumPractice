package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//.isDisplayed();
		/*
		boolean display = driver.findElement(By.xpath("//label[text()='First name:']")).isDisplayed();
		boolean display = driver.findElement(By.xpath("//input[@id='FirstName']")).isDisplayed();
		System.out.println("First Name Box is displayed true or false ?: " +display);
		*/
		
		//.isEnabled();
		/*
		//boolean enable = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		boolean enable = driver.findElement(By.xpath("//h1[normalize-space()='Register']")).isEnabled();
		System.out.println("First Name Box Can be Operated true or false ?: " +enable);
		*/
		
		//.isSelected();
		System.out.println(driver.findElement(By.xpath("//input[@value='M']")).isSelected());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='M']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='M']")).isSelected());
		
		
		driver.quit();
	}

}

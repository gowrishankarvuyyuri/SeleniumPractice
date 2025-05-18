package Selenium_FirstDay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri_Automation {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		String name = driver.findElement(By.xpath("//a[text()='Login']")).getText();
		String Name = driver.findElement(By.xpath("//a[text()='Login']")).getAttribute("value");
		
		System.out.println(name+ "\n" + Name);
		
		/*
		driver.findElement(By.cssSelector("[placeholder='Enter your active Email ID / Username']")).sendKeys("gowrishankarvuyyuri@outlook.com");
		
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("GowriShankar2002");
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.findElement(By.cssSelector("[href='/mnjuser/profile']")).click();
		
		driver.findElement(By.xpath("//div[@class='widgetHead']/span[text()='editOneTheme']")).click();
		*/
		
		/*
		String Matter = driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).getText();
		StringBuffer matter = new StringBuffer(Matter);
		*/
		
		/*
		WebElement Resume = driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//clearing the value inside the field
		js.executeScript("arguments[0].value = '';", Resume);
		
		//getting value printed inside WebElement
		System.out.println("After clear: " + Resume.getAttribute("value"));
		*/
		
		/*
		if (matter.charAt(matter.length()-1) == '.') 
			matter.deleteCharAt(matter.length()-1);
	
		else 
			matter.append(".");
		
		System.out.println(matter);
		
		//driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).sendKeys(matter);
		
		driver.findElement(By.xpath("//button[@class='btn-dark-ot'][text()='Save']")).click();
		*/
		
		/*
		WebElement save_btn = driver.findElement(By.xpath("//button[@class='btn-dark-ot'][text()='Save']"));
		JavascriptExecutor jss = (JavascriptExecutor)driver;
		jss.executeScript("arguments[0].click();", save_btn);
		*/
	}

}

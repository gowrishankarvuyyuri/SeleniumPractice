package SeleniumLocators;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS_Selectors_Locators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// nopcommerce demo website
		/*
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//tag with id 			tag#id/#id
		/*
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Pants");
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Pants");
		*/
		
		//tag with classname		tag.classname
		/*
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Pants");
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Pants");
		*/
		
		//tag with attribute		tag[attribute='value']
		/*
		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Pants");
		driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("Pants");
		*/
		
		//tag with class, attribute		tag.className[attribute = 'value']
		/*
		driver.findElement(By.cssSelector(".search-box-text[placeholder=\"Search store\"]")).sendKeys("Pants");
		driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("Pants");
		
		driver.close();
		*/
		
		
		
		// Narkri Website
		/*
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		//tag with class -- found two webelements;
		//driver.findElement(By.cssSelector("input.suggestor-input")).sendKeys("Selenium");
		
		//tag with class and attribute  -- found single webelement
		//driver.findElement(By.cssSelector("input.suggestor-input[placeholder='Enter skills / designations / companies']")).sendKeys("Selenium");
		
		//tag with id
		//driver.findElement(By.cssSelector("a#login_Layer")).click();
		//driver.findElement(By.id("login_Layer")).click();
		//driver.findElement(By.linkText("Login")).click();
		
		//tag with attribute
		//driver.findElement(By.cssSelector("[title='Explore top companies hiring on Naukri']")).click();
		driver.findElement(By.cssSelector("a[title='Explore top companies hiring on Naukri']")).click();
		
		driver.close();
		*/
	}

}

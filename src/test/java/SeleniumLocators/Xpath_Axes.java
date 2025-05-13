package SeleniumLocators;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_Axes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		//locating Self Element
		String text = driver.findElement(By.xpath("//a[text()='CARE Ratings']/self::a")).getText();
		System.out.println("Self elementName: "+text);
		text = driver.findElement(By.xpath("//a[text()='CARE Ratings']/self::a")).getTagName();
		System.out.println("Self tagName: "+text);
		
		//locating Parent Element
		text = driver.findElement(By.xpath("//a[contains(text(), 'Dynamics')]/parent::*")).getTagName(); //one child contains one parent you may use tagName or '*' instead
		System.out.println("Parent TagName: "+text);
		
		//locating Ancestor Element (Parent-Parent)
		text = driver.findElement(By.xpath("//a[contains(text(), 'Dynamics')]/ancestor::td")).getTagName(); //one child contains one parent you may use tagName or '*' instead
		System.out.println("Ancestor TagName: "+text);
		
		//locating Preceding
		text = driver.findElement(By.xpath("//td[contains(text(), '1,744.85')]/preceding::td[1]")).getText();
		System.out.println("Preceding Name: "+text);
		/*
		List <WebElement> texts = driver.findElements(By.xpath("//td[contains(text(), '1,744.85')]/preceding::td"));
		System.out.println("List of Preceding Tags/Elements");
		for(WebElement txt : texts) {
			System.out.println("\t" + txt.getText());
		}
		System.out.println();
		*/
		
		//locating followings
		text = driver.findElement(By.xpath("//td[contains(text(), '1,744.85')]/following::a[3]")).getText();
		System.out.println("Following Name: "+text);
		
		//locating preceding siblings
		driver.findElement(By.xpath("//a[text()='Indian Overseas']/parent::span/preceding-sibling::span[2]/a"));
		
		//locating following siblings
		driver.findElement(By.xpath("//a[contains(text(),'Indian')]/parent::span/following=sibling::span[3]/a"));
		
		//locating child
		driver.findElement(By.xpath("driver.findElement(By.xpath(\"//a[contains(text(),'Indian')]/parent::span/following=sibling::span[3]/a\"));"));
		
		//locating descendant
		driver.findElement(By.xpath("//a[text()='CARE Ratings']/parent::td/parent::tr/descendant::span"));
		
	
		driver.quit();
	}

}

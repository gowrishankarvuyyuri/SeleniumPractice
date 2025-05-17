package RadioButtons_CheckBoxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		/*
		List<WebElement> Elements = driver.findElements(By.xpath("//div[contains(@class,'form-check form-check-inline')]/input[@type='checkbox']"));
		
		//selecting all options
		for(WebElement Element : Elements) {
			Element.click();
		}
		
		Thread.sleep(2000);
		
		//deselecting all options
		for(WebElement Element : Elements) {
			Element.click();
		}
		
		Thread.sleep(2000);
		
		//selecting particular option 
		for(int i =0; i<Elements.size(); i++) {
			if(i == 2 || i == 6)
				Elements.get(i).click();
		}
		
		//selecting an particular option by attribute value
		for(WebElement Element : Elements) {
			String value = Element.getAttribute("id");
			if(value.equals("wednesday"))
				Element.click();
		}
		*/
		
		
		List<WebElement> Elements = driver.findElements(By.xpath("//table[@id='productTable']//input"));
		
		//selecting all
		for (WebElement Element : Elements) {
			Element.click();
		}
		
		Thread.sleep(2000);
		
		//deselecting all
		for (WebElement Element : Elements) {
			Element.click();
		}
		
		//selecting particular
		for(int i =0; i < Elements.size(); i++) {{
			WebElement element = driver.findElement(By.xpath("(//table[@id='productTable']//input)[\" + (i + 1) + \"]/ancestor::tr/child::td[2]"));
			String Name = element.getText().trim();
			if(Name.equals("Smartwatch")) {
				Elements.get(i).click();
				break;
			}
		}
	}
	}
}

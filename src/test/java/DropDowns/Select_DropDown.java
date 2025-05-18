package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_DropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select dropdown_list = new Select(dropdown);
		
		
		dropdown_list.selectByVisibleText("Japan"); // --- by visibleText
		dropdown_list.selectByValue("germany");
		dropdown_list.selectByIndex(1);
		List<WebElement> list = dropdown_list.getAllSelectedOptions();
		for(WebElement lst : list) {
			System.out.print(lst.getText()+" ");
		}
		System.out.println(list.size());
		
		List<WebElement> all_opts = dropdown_list.getOptions();
		for(WebElement all_opt : all_opts) {
			System.out.print(all_opt.getText()+" ");
		}
		
		System.out.println("Count of Options :"+ all_opts.size()); // --- getting all count of size
		
	}

}

package WebTables;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_WebTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> Headings = driver.findElements(By.xpath("//table[@id='taskTable']/thead//th"));
		int count = 1;
		for(WebElement Head : Headings) {
			String h =Head.getText();
			if(h.equals("CPU (%)")) {
				break;
			}
			else
				count+=1;
		}
		System.out.println(count);
		
		
		List<WebElement> cpus = driver.findElements(By.xpath("//table[@id='taskTable']/tbody/tr/td["+count+"]"));
		
		for(int i=1; i<=cpus.size(); i++) {
			
			WebElement cpu = driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr["+i+"]/td["+count+"]"));
			StringBuffer value = new StringBuffer(cpu.getText());
					
			value.deleteCharAt(value.length()-1);			
			String Nm = "";
			String Name = value.toString();
			
			float val = Float.parseFloat(Name);
			
			if(val < 5.0) {
				try {
				Nm = driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr["+i+"]/td[1]")).getText();
				}
				catch(Exception e) {
					e.getStackTrace();
					System.out.println("Halting here");
				}
				finally {
					System.out.println(Nm);
				}
			}
			else
				continue;
		}
	}

}

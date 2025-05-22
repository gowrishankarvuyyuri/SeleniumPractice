package Data_Driven_Automation;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Deposit_Calculator_Automation {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications", "--disable-popup-blocking", "--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(opt);
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.document.body.style.zoom='80%'");
		
		
		driver.get(PropertyUtlity.getXpath("PageUrl"));
		Thread.sleep(2000);
		
		
		//WebElements Locations
		WebElement Amount = driver.findElement(By.xpath(PropertyUtlity.getXpath("input1")));
		WebElement Length = driver.findElement(By.xpath(PropertyUtlity.getXpath("input2")));
		WebElement Intrest = driver.findElement(By.xpath(PropertyUtlity.getXpath("input3")));
		
		
		String path = System.getProperty("user.dir") + PropertyUtlity.getXpath("fileextention");
		String sheet_name = "Sheet1";
		String message;
		
		
		int n_row = ExcelUtility.getRowNumbers(path, sheet_name);
		int n_cell = ExcelUtility.getCellNumbers(path,sheet_name, n_row);
		
		driver.findElement(By.xpath(PropertyUtlity.getXpath("notification"))).click();		
		
		for(int row = 1; row <= n_row; row++) {	
			
			ExcelUtility.ClearFields(Amount, Length, Intrest);
			
			//read the data from excel and store it a variable

			String amount = ExcelUtility.getCellData(path, sheet_name, row, 0);
			String length = ExcelUtility.getCellData(path, sheet_name, row, 1);
			String intrest = ExcelUtility.getCellData(path, sheet_name, row, 2);
			String compound = ExcelUtility.getCellData(path, sheet_name, row, 3);
			String expect_amount = ExcelUtility.getCellData(path, sheet_name, row, 4);
			
			
			//sending data to the WebElements
			Amount.sendKeys(amount);
			Length.sendKeys(length);
			Intrest.sendKeys(intrest);
			
			driver.findElement(By.xpath(PropertyUtlity.getXpath("input4"))).click();			
			List<WebElement> options = driver.findElements(By.xpath(PropertyUtlity.getXpath("input4_list")));
			
			for(WebElement option : options) {
				
				String string = option.getText();
				if(string.equals(compound)) {
					
					action.moveToElement(option).click().perform();
					break;
				}
			}
	
			
			driver.findElement(By.xpath(PropertyUtlity.getXpath("clicking"))).click();
			Thread.sleep(2000);
			
			String actual_amount = driver.findElement(By.xpath(PropertyUtlity.getXpath("result"))).getText();
			
			StringBuffer buffer = new StringBuffer(actual_amount);
			buffer.deleteCharAt(0);
			actual_amount = buffer.toString();
			
			Thread.sleep(2000);
			
			//validation
			if(expect_amount.equals(actual_amount)) {
				message = "Passed";
				System.out.println("Test Case Passed");
				ExcelUtility.setCellData(path, sheet_name, row, 6, message);
				
			}
			else {
				message = "Failed";
				System.out.println("Test Case Failed");
				ExcelUtility.setCellData(path, sheet_name, row, 6, message);
			}
			
		}
		driver.quit();
		
	}

}

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
		
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		Thread.sleep(2000);
		
		
		//WebElements Locations
		WebElement Amount = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement Length = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement Intrest = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		
		
		String path = System.getProperty("user.dir") + "\\TestData\\Deposit_Calculator.xlsx";
		String sheet_name = "Sheet1";
		
		
		int n_row = ExcelUtility.getRowNumbers(path, sheet_name);
		int n_cell = ExcelUtility.getCellNumbers(path,sheet_name, n_row);
		
		driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();		
		
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
			
			driver.findElement(By.xpath("//mat-select[@role='combobox']")).click();			
			List<WebElement> options = driver.findElements(By.xpath("//div[@id='cdk-overlay-0']//mat-option/span"));
			
			for(WebElement option : options) {
				
				String string = option.getText();
				if(string.equals(compound)) {
					
					action.moveToElement(option).click().perform();
					break;
				}
			}
	
			
			driver.findElement(By.xpath("//form/div/div[5]/button")).click();
			Thread.sleep(2000);
			
			String actual_amount = driver.findElement(By.xpath("//div[@id='validResults']//span[4]")).getText();
			
			StringBuffer buffer = new StringBuffer(actual_amount);
			buffer.deleteCharAt(0);
			actual_amount = buffer.toString();
			
			Thread.sleep(2000);
			
			//validation
			if(expect_amount.equals(actual_amount)) 
				System.out.println("Test Case Passed");
			else
				System.out.println("TestCase Not Passed");
			
		}
		driver.quit();
		
	}

}

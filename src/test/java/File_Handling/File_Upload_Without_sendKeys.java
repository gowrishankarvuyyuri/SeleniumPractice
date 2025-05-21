package File_Handling;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload_Without_sendKeys {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.naukri.com/");
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.cssSelector("[placeholder='Enter your active Email ID / Username']")).sendKeys("gowrishankarvuyyuri@outlook.com");
		
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("GowriShankar2002");
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.findElement(By.cssSelector("[href='/mnjuser/profile']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Update resume']")).click();

		Thread.sleep(2000);
		
		//which will capture/copying the file path to the clipboard
		StringSelection stringSelection = new StringSelection("C:\\Users\\gowri\\Downloads\\Learnings\\GowriShankar_MResume.pdf");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		Thread.sleep(2000);
		
		//paste it in file path prompt using robot class 
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(2000);
		
		//click file to upload
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.close();
	}

}

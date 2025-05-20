package File_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Single_Upload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//uploading single file
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:/Users/gowri/Downloads/Learnings/Java learning.txt");

		//validation
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("Java learning.txt"))
			System.out.println("File is Uploaded");
		else
			System.out.println("File is not Uploaded");
	}

}

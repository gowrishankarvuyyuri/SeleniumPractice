package File_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mutiple_Upload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		String file1 = "C:/Users/gowri/Downloads/Learnings/Java learning.txt";
		String file2 = "C:/Users/gowri/Downloads/Learnings/Automation Learning Paths.txt";
		
		//uploading multiple files
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 +"\n"+ file2);
		
		//validating them
		String file_1 = driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText();
		String file_2 = driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText();
		
		if(file_1.equals("Java learning.txt") && file_2.equals("Automation Learning Paths.txt"))
			System.out.println("File is Uploaded");
		else
			System.out.println("File is not Uploaded");
		
		System.out.println(driver.findElements(By.xpath("//ul[@id='fileList']/li")).size());
	}

}

package File_Handling;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class File_Download {

	public static void main(String[] args) throws InterruptedException {
		
		HashMap<String, Object> chromePrefs = new HashMap<>();
		
		String folder_path = System.getProperty("user.dir").concat("\\Downloads\\"); //specifying the folder path where file shoould be moved
		
		chromePrefs.put("profile.default_content_settings.popups", 0);	//popups will be disabled
		chromePrefs.put("download.default_directory", folder_path);	//settin download folder
		chromePrefs.put("download.prompt_for_download", false);	//promps will be disabled
		chromePrefs.put("safebrowsing.enabled", true); 
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.naukri.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[placeholder='Enter your active Email ID / Username']")).sendKeys("gowrishankarvuyyuri@outlook.com");
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("GowriShankar2002");	
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[href='/mnjuser/profile']")).click();	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//i[@title='Click here to download your resume']")).click();
		
		Thread.sleep(5000);
		
		//validation
		/*
		Path path = Paths.get("C:\\Users\\gowri\\GowriShankar_WorkSpace\\SeleniumWebDriverPractice\\Downloads\\Resume.pdf");
		
		if(Files.exists(path))
			System.out.println("File Downloaded Sucessfully");
		else
			System.out.println("File Not Downloaded !!");
		*/
		

		/*
		File file = new File(System.getProperty("user.dir").concat("Resume.pdf"));
		
		if(file.exists())
			System.out.println("File Downloaded Sucessfully");
		else
			System.out.println("File Not Downloaded !!");
		
		driver.close();
		 */

	}
}

package ChromeOptions_Class;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

public class HeadLess_Testing {

	public static void main(String[] args) {
		
		//declaration 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		//assignation
		ChromiumDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.naukri.com/");
		
		String driver_title = driver.getTitle();
		
		String expected_title = "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
		
		System.out.println((driver_title.contains(expected_title))? "Test Case Passed" : "Test Case Failed");
		
		driver.quit();
	}

}

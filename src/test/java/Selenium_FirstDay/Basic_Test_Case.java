package Selenium_FirstDay;

/*
 Testcase :
 Launch a Chrome/Edge Browser
 Open the Url "https://www.naukri.com/mnjuser/homepage"
 Get the Title of the Page and Validate with expected
 close the browser
 */


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.*;

public class Basic_Test_Case {

	public static void main(String[] args) throws InterruptedException {
		
		//driver initialization/declaration/launching
		/*
		ChromeDriver cdrive = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		*/
		ChromiumDriver driver = new ChromeDriver();
		
		//opening the url
		driver.get("https://www.naukri.com/");
		
		//storing the title into a String variable
		String driver_title = driver.getTitle();
		
		//Thread.sleep(5000);
		
		String expected_title = "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
		
		//validating and priting the result
		System.out.println((driver_title.contains(expected_title))? "Test Case Passed" : "Test Case Failed");
		
		//closing the browser
		//driver.close();
		driver.quit();
	}

}

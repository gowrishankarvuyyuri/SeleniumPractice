package ChromeOptions_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Incognito_Mode {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"}); // Disabling Automated Message
		options.setAcceptInsecureCerts(true);
		options.addArguments("--incognito"); // opens in a incognito mode
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");

	}

}

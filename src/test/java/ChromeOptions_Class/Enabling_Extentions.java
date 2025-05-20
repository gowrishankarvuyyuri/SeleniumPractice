package ChromeOptions_Class;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

public class Enabling_Extentions {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File (System.getProperty("user.dir") + "\\CrxExtractions\\SelectorsHub.crx" ));
		options.addArguments("--start-maximized", "--disable-notifications", "--incognito", "--diable-popup-blocking");
		
		ChromiumDriver driver = new ChromeDriver(options);
		
		driver.get("http://textcompare.com/#google_vignette");

	}

}

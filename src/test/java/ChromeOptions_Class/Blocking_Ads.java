package ChromeOptions_Class;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

public class Blocking_Ads {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File (System.getProperty("user.dir") + "\\CrxExtractions\\AdBlock.crx" ));
		
		ChromiumDriver driver = new ChromeDriver(options);
		
		driver.get("http://textcompare.com/#google_vignette");
	}

}

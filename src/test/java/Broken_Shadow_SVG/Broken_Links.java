package Broken_Shadow_SVG;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

/*
 ->collect all <a> tags from the page and filter out the href attribute which has null or empty.
 ->upon filtering, capture all the links and convert it into URL object later establish a connection 
 through .openConnection() and .connect(). 
 ->validate the respose code through .getResponseCode() if it is returning >=400 then it is a broken 
 else not-broken .
 */

public class Broken_Links {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		ChromiumDriver driver = new ChromeDriver(options);
		driver.get("http://www.deadlinkcity.com/");
		
		//step1
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int broken_links = 0;
		int non_broken_links = 0;
		int count = 0;
		
		for(WebElement link : links) {
			
			String lk = link.getAttribute("href");
			if(lk == null || lk.isEmpty()) {
				count+=1;
				continue;
			}
			
			//step2
			try {
				URL url = new URL(lk);
				HttpURLConnection httpLink = (HttpURLConnection)url.openConnection();
				httpLink.connect();
				
				//step3
				if(httpLink.getResponseCode() >= 400) {
					System.out.println("Link is Broken!! -> " + lk);
					broken_links+=1;
				}
				else {
					System.out.println("Link is non-Broken!! -> " + lk);
					non_broken_links+=1;
				}
			
			}
			catch(Exception e) {
				e.getStackTrace();
			}
			
		}
		System.out.println("\nNumber of Broken Links are " + broken_links + "\nNumber of Non Broken Links are " + non_broken_links + "\nNumber of Links are Empty/Null are " + count);

	}

}

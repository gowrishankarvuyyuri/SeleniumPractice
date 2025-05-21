package Handling_Concepts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies_Handling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.naukri.com/");
		
		//Retrieving all cockies
		Set<Cookie> cookies = driver.manage().getCookies();
		
		//printing them using enhanced for-loop
		/*for(Cookie cookie : cookies) {
			System.out.println(cookie.getName() +" -> "+ cookie.getValue());
		}
		*/
		
		//counting size
		System.out.println("Original Cookie State : " + driver.manage().getCookies().size());
		
		//Retrive specific cookie
		System.out.println(driver.manage().getCookieNamed("_t_ds")); //_t_ds -> 12a6b13b1747805720-2612a6b13b-012a6b13b
		
		//adding a new coockie
		Cookie cookie1 = new Cookie("User","Gowri");
		driver.manage().addCookie(cookie1);
		System.out.println("After Adding A New Cookie : " + driver.manage().getCookies().size());
		
		//deleting a specific coockie through object
		driver.manage().deleteCookie(cookie1);
		System.out.println("Ater Deleting the New Cookie through object : " + driver.manage().getCookies().size());
		
		//deleting a specific cookie through Name
		driver.manage().deleteCookieNamed("_t_ds");
		System.out.println("Ater Deleting the New Cookie through Name: " + driver.manage().getCookies().size());
		
		//deleting all cookies
		driver.manage().deleteAllCookies();
		System.out.println("Ater Deleting All Cookies : " + driver.manage().getCookies().size());
		
		driver.close();
	}

}

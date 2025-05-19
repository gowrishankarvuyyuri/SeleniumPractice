package DatePickers_Calender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker1 {

	static void datepicker1(WebDriver driver, String date, String month, int expect_year) {
		
		//System.out.println("Inside Methods");
		
		String Year= driver.findElement(By.xpath("//div[@class = 'ui-datepicker-title']/span[2]")).getText();
		int actual_year = Integer.parseInt(Year);
		
		//System.out.println(actual_year);
		
		int flag = 0;
		
		if(expect_year < actual_year) {	
			//System.out.println("Inside Year Looping");
			while(true) {
				driver.findElement(By.xpath("//span[text() = 'Prev']")).click();
				String year_loop = driver.findElement(By.xpath("//div[@class = 'ui-datepicker-title']/span[2]")).getText();
				int year = Integer.parseInt(year_loop);
				if(year == expect_year) {
					while(true) {
						driver.findElement(By.xpath("//span[text() = 'Prev']")).click();
						String month_loop = driver.findElement(By.xpath("//div[@class = 'ui-datepicker-title']/span[1]")).getText();
						if((month_loop.equals(month))) {
							List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td"));
							for(WebElement element : elements) {
								if(date.equals(element.getText())){
									element.click();
									flag +=1;
									break;
								}
							}
						}
						if(flag == 1) {
							flag+=1;
							break;
						}
					}
				}
				if(flag == 2) {
					break;
				}
			}
		}
		else {
			while(true) {
				driver.findElement(By.xpath("//span[text() = 'Next']")).click();
				String year_loop = driver.findElement(By.xpath("//div[@class = 'ui-datepicker-title']/span[2]")).getText();
				int year = Integer.parseInt(year_loop);
				System.out.println(year);
				if(year == expect_year) {
					while(true) {
						driver.findElement(By.xpath("//span[text() = 'Next']")).click();
						String month_loop = driver.findElement(By.xpath("//div[@class = 'ui-datepicker-title']/span[1]")).getText();
						System.out.println(month_loop);
						if((month_loop.equals(month))) {
							List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td"));
							for(WebElement element : elements) {
								if(date.equals(element.getText())){
									element.click();
									flag +=1;
									break;
								}
							}
						}
						if(flag == 1) {
							flag+=1;
							break;
						}
					}
				}
				if(flag == 2) {
					break;
				}
			}
		}
	}
}



/*
 
static Month convertMonth(String month) {
        HashMap<String, Month> monthMap = new HashMap<>();

        monthMap.put("January", Month.JANUARY);
        monthMap.put("February", Month.FEBRUARY);
        monthMap.put("March", Month.MARCH);
        monthMap.put("April", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("June", Month.JUNE);
        monthMap.put("July", Month.JULY);
        monthMap.put("August", Month.AUGUST);
        monthMap.put("September", Month.SEPTEMBER);
        monthMap.put("October", Month.OCTOBER);
        monthMap.put("November", Month.NOVEMBER);
        monthMap.put("December", Month.DECEMBER);

        Month vmonth = monthMap.get(month);

        if (vmonth == null) {
            System.out.println("Invalid Month...");
        }

        return vmonth;
   }
   
 */

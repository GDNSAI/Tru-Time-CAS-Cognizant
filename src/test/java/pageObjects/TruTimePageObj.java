package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CalenderDDMMYYY;

public class TruTimePageObj {
	
	public WebDriver driver;
	
	public TruTimePageObj(WebDriver driver){
		this.driver = driver;

	}
	
	ArrayList<String> legendAl = new ArrayList<String>();
	ArrayList<String> truTimeDates = new ArrayList<String>();
	CalenderDDMMYYY myCalender = new CalenderDDMMYYY();
	By truTimeMonth = By.xpath("//div[@class = 'ui-datepicker-title']/span[1]");
	By truTimeYear = By.xpath("//div[@class = 'ui-datepicker-title']/span[2]");
	By txtBackdated = By.cssSelector("span.topupavailablefromDate");
	By legends = By.xpath("//ul[@class = 'legend-labels']/li");
	By txtHighlighted = By.xpath("//div[@ng-if = 'item.Date==activeDate']");
	
	public String getMonth() {
		String mon = driver.findElement(truTimeMonth).getText();
		System.out.println(mon);
		return mon;
	}
	
	public String getYear() {
		String year = driver.findElement(truTimeYear).getText();
		System.out.println(year);
		return year;
	}
	
	public String backDatedTopUp() {
		
		return driver.findElement(txtBackdated).getText();
	}
	
	public int getLegends() {
		
		for(int i =2; i<=30; i+=2) {
			WebElement legends = driver.findElement(By.xpath("//ul[@class = 'legend-labels']/li["+i+"]"));
			String txtLegend = legends.getText();
			legendAl.add(txtLegend);
			System.out.println(txtLegend);
		}
		System.out.println(legendAl.size());
		return legendAl.size();
		
	}
	
	public String getCurrentHighlightedDay() {
		System.out.println(driver.findElement(txtHighlighted).getText());
		
		return driver.findElement(txtHighlighted).getText();
	}
	
	public boolean getCurrentWeekDatesInTruTime() {
		
		
		List<WebElement> currentTruTimeDates = driver.findElements(By.xpath("//div[@class='weekContainer']//div[contains(@class,'dayHeadr')]"));
	   	
		for(int i=0;i<7;i++) {
	   		truTimeDates.add(currentTruTimeDates.get(i).getText());
	   	 }
		
		System.out.println("TruTime Dates size "+truTimeDates.size());
		
		boolean flag = true;
		for(int j=0; j<7; j++) {
			if(truTimeDates.get(j).equals(myCalender.localWeekDates().get(j))) {
				System.out.println(truTimeDates.get(j));
			} else {
				flag = false;
			}
		}
		return flag;
	}
}

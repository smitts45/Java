package Mavenp.Maven2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test2 extends Master1myself

{
	private static final Logger log =Logger.getLogger(Test2.class);
	public static void main(String[] args) throws Exception 
	{
		
		init1();
		test1 = report1.startTest("Test2");
		test1.log(LogStatus.INFO, "Initializing Properties file");
		Launch("chromebrowser");
		test1.log(LogStatus.INFO, "launching browser : "+ dp1.getProperty("chromebrowser"));
		NavigateUrl("walmarturl");
		test1.log(LogStatus.INFO, "Launching Url"+ childP.getProperty("Walmart"));
		driver1.manage().deleteAllCookies();
		driver1.findElement(By.id("global-search-input")).sendKeys("halloween");
		test1.log(LogStatus.PASS, "Entered Halloween in the search box");
		driver1.findElement(By.xpath("//button[@id='global-search-submit']//img")).click();
		test1.log(LogStatus.INFO, "Clicked the search button");
		Thread.sleep(4000);
		
		report1.endTest(test1);
		report1.flush();
		driver1.close();
		
	}

}

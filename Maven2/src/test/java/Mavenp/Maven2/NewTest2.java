package Mavenp.Maven2;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class NewTest2 extends Master1myself
{
  @Test(groups= {"regression"})
  public void f() {
	  driver1.findElement(By.id("global-search-input")).sendKeys("halloween");
		test1.log(LogStatus.PASS, "Entered Halloween in the search box");
		driver1.findElement(By.xpath("//button[@id='global-search-submit']//img")).click();
		test1.log(LogStatus.INFO, "Clicked the search button");
		
  }
  @BeforeMethod(groups= {"regression"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws Exception {
	 
		init1();
		 test1 = report1.startTest("Test2");
		test1.log(LogStatus.INFO, "Initializing Properties file");
		Launch(bType);
		test1.log(LogStatus.INFO, "launching browser : "+ dp1.getProperty("chromebrowser"));
		NavigateUrl("walmarturl");
		test1.log(LogStatus.INFO, "Launching Url"+ childP.getProperty("Walmart"));
		driver1.manage().deleteAllCookies();
  }

  @AfterMethod(groups= {"regression"})
  public void afterMethod() {
	  report1.endTest(test1);
		report1.flush();
		driver1.close();
  }

}

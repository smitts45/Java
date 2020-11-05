package Mavenp.Maven2;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;

public class NewTest1 extends Master1myself
{
  @Test(groups= {"regression","smoke"})
  public void f() {
	  
	  
		driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("halloween");
		test1.log(LogStatus.INFO, "put halloween in searchbox");
		driver1.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]")).click();
		
  }
  @BeforeMethod(groups= {"regression","smoke"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws Exception {
	  
	  
	  init1();
	  test1= report1.startTest("Test1");
	  test1.log(LogStatus.INFO, "Initializing properties file....");
	  
		Launch(bType);
		test1.log(LogStatus.INFO, "launching browser : "+ dp1.getProperty("chromebrowser"));
		
		NavigateUrl("amazonurl");
		test1.log(LogStatus.INFO, "Launching Url"+ childP.getProperty("Amazon"));
		
  }

  @AfterMethod(groups= {"regression","smoke"})
  public void afterMethod() {
	  report1.endTest(test1);
		report1.flush();
		driver1.close();
		
	  
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}

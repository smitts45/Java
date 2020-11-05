package Mavenp.Maven2;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class NewTest3Extent extends Master1myself
{
  @Test(groups= {"regression","smoke"})
  public void f() throws Exception 
  {
	  typeText("facebook_id","abc@yahoo.com");
		test1.log(LogStatus.INFO, "Giving values(incorrect id)using locator:  "+ orProp1.getProperty("facebook_id"));
		
		
		typeText("facebookpass_xpath", "123");
		test1.log(LogStatus.INFO,"Giving values(incorrect password) using locator: "+orProp1.getProperty("facebookpass_xpath") );
		
		
		elementClick("facebooklog_id");
		test1.log(LogStatus.INFO, "clicked the button using locator: "+ orProp1.getProperty("facebooklog_id"));
		
		Thread.sleep(14000);
  }
  @BeforeMethod(groups= {"regression","smoke"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws Exception {
	  init1();
		test1= report1.startTest("X_path2Extent");
		test1.log(LogStatus.INFO, "Initializing properties file....");
		
	Launch(bType);
	test1.log(LogStatus.INFO, "launching browser : "+ dp1.getProperty("chromebrowser"));
	
	
	NavigateUrl("facebookurl");
	test1.log(LogStatus.PASS, "launching url: " + childP.getProperty("facebookurl"));
	
	
  }

  @AfterMethod(groups= {"regression","smoke"})
  public void afterMethod() {
	  report1.endTest(test1);
		report1.flush();
		driver1.close();
		
  }

}

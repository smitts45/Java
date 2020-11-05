package Mavenp.Maven2;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

//import com_selem.MasterLaunch;

public class X_path2Extent extends Master1myself
{
	private static final Logger log =Logger.getLogger(X_path2Extent.class);

	public static void main(String[] args) throws Exception
	{
		init1();
		test1= report1.startTest("X_path2Extent");
		test1.log(LogStatus.INFO, "Initializing properties file....");
		
	Launch("chromebrowser");
	test1.log(LogStatus.INFO, "launching browser : "+ dp1.getProperty("chromebrowser"));
	
	
	NavigateUrl("facebookurl");
	test1.log(LogStatus.PASS, "launching url: " + childP.getProperty("facebookurl"));
	
	
	typeText("facebook_id","abc@yahoo.com");
	test1.log(LogStatus.INFO, "Giving values(incorrect id)using locator:  "+ orProp1.getProperty("facebook_id"));
	
	
	typeText("facebookpass_xpath", "123");
	test1.log(LogStatus.INFO,"Giving values(incorrect password) using locator: "+orProp1.getProperty("facebookpass_xpath") );
	
	
	elementClick("facebooklog_id");
	test1.log(LogStatus.INFO, "clicked the button using locator: "+ orProp1.getProperty("facebooklog_id"));
	
	Thread.sleep(14000);
	
	
	report1.endTest(test1);
	report1.flush();
	driver1.close();
	
	

	}

}

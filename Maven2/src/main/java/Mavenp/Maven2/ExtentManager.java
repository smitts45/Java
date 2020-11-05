package Mavenp.Maven2;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

//import com_selem.MasterLaunch;

public class ExtentManager extends Master1myself
{ 
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if (report==null) 
		{
			report = new ExtentReports(Projectpath1 + "//HtmlReports//" + "report.html");
			report.loadConfig(new File(Projectpath1 + "//extentreportconfig.xml"));
			report.addSystemInfo("Selenium Language Binding", "3.141.59").addSystemInfo("Environment",ParentP.getProperty("env"));
		}
		return report;
	}

}
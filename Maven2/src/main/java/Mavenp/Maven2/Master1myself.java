package Mavenp.Maven2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class Master1myself {
	public static WebDriver driver1;
	public static FileInputStream fis1;
	public static String Projectpath1= System.getProperty("user.dir");
	public static Properties dp1;
	public static Properties ParentP; 
	public static Properties childP;	 
	public static Properties orProp1;		
	public static ExtentReports report1;
	public static ExtentTest test1;

	public static void init1() throws Exception
	{
		fis1=new FileInputStream(Projectpath1+ "//data.properties");
		dp1=new Properties();
		dp1.load(fis1);
		
		fis1= new FileInputStream(Projectpath1+ "//environment.properties");
		ParentP= new Properties();
		ParentP.load(fis1);
		String e= ParentP.getProperty("env");
		System.out.println(e);
		
		fis1= new FileInputStream(Projectpath1+ "//"+ e+ ".properties");
		childP= new Properties();
		childP.load(fis1);
		System.out.println(childP.getProperty("amazon"));
		
		fis1=new FileInputStream(Projectpath1+ "//or.properties");
		orProp1= new Properties();
		orProp1.load(fis1);
		
		fis1=new FileInputStream(Projectpath1 + "//log4jconfig.properties");
		PropertyConfigurator.configure(fis1);
		
		report1= ExtentManager.getInstance();
		
		//driver1.quit();
		
	}

	public static void Launch(String browser) 
	{
		if(dp1.getProperty(browser).equals("chrome"))
		{
			ChromeOptions option= new ChromeOptions();
option.addArguments("user-data-dir=C:\\Users\\nstar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3");
			driver1= new ChromeDriver(option);
			
		}else if (dp1.getProperty(browser).equals("firefox"))
		
		{
			ProfilesIni p= new ProfilesIni();
			FirefoxProfile profile = p.getProfile("seleniumP1");
			FirefoxOptions option= new FirefoxOptions();
			option.setProfile(profile);
			driver1= new FirefoxDriver(option);
			profile.setPreference("dom.webnotifications.enabled", false);
		}
	}
	public static void NavigateUrl(String url)
	{
		driver1.get(childP.getProperty(url));
		
	}
	public static void elementClick(String locatorkey) 
	{
		getElement(locatorkey).click();
		
	}

	

	public static void typeText(String locatorkey, String text) 
	{
		getElement(locatorkey).sendKeys(text);
		
	
	}

	public static void selectOption(String locatorkey, String option) 
	{
		getElement(locatorkey).sendKeys(option);
		
		
	}
	
	public static WebElement getElement(String locatorkey)
	{
		WebElement element= null;
		if (locatorkey.endsWith("_id")) 
		{
			element=driver1.findElement(By.id(orProp1.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_name"))
		{
			element= driver1.findElement(By.name(orProp1.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_xpath"))
		{
			element=driver1.findElement(By.xpath(orProp1.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_classname"))
		{
			element=driver1.findElement(By.className(orProp1.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_css"))
		{
			element=driver1.findElement(By.cssSelector(orProp1.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_linktext"))
		{
			element=driver1.findElement(By.linkText(orProp1.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_partiallinktext"))
		{
			element=driver1.findElement(By.partialLinkText(orProp1.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_tagname"))
		{
			element=driver1.findElement(By.tagName(orProp1.getProperty(locatorkey)));
		}
		return element;	
	}
	

	public static void reportSuccess(String PassMsg)
	{
		test1.log(LogStatus.PASS, PassMsg);	
	}

	public static void reportFailure(String FailMsg) 
	{
		test1.log(LogStatus.FAIL, FailMsg);
	}

	public static boolean isLinkEqual(String expectedlink) 
	{
		String actuallink = driver1.findElement(By.xpath("//a[contains(text(),'Best Sellers')]")).getText();//innerHTML,href,classname
		if(actuallink.equals(expectedlink))
			return true;
		else
			return false;
	}
	public static void screenshotf() throws Exception 
	{
		Date dt= new Date();
		String	s=dt.toString().replace(':', '_').replace(' ','_')+".png";
		File src= ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File( Projectpath1 +"\\failurescreenshot\\"+ s));
		test1.log(LogStatus.INFO,"Screenshot...." + test1.addScreenCapture(Projectpath1 +"\\failurescreenshot\\"+ s));
	}
	
	}
	
	
	
	
	


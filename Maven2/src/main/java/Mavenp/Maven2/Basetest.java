package Mavenp.Maven2;

import java.io.File;
import java.io.FileInputStream;
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
public class Basetest 
{
	public static WebDriver driver;
	public static FileInputStream fis;
	public static String projectpath = System.getProperty("user.dir");
	public static Properties dp;
	public static Properties parentProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String filePath;
	public static String sheetName ;
	public static String testName ;

	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ', '_');
	}
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectpath +"//data.properties");
		dp = new Properties();
		dp.load(fis);
		
		fis = new FileInputStream(projectpath +"//environment.properties");
		parentProp = new Properties();
		parentProp.load(fis);
		String e = parentProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath + "//" + e + ".properties");
		childProp = new Properties();
		childProp.load(fis);
		System.out.println(childProp.getProperty("amazonurl"));
		
		fis = new FileInputStream(projectpath + "//or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectpath + "//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
	}
	
	public static void launch(String browser)
	{
		if(dp.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome");
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\nstar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3");
			option.addArguments("--disable-notifications");
			
			
			driver = new ChromeDriver(option);
		}else if (dp.getProperty(browser).equals("firefox"))
			
		{
			ProfilesIni p= new ProfilesIni();
			FirefoxProfile profile = p.getProfile("seleniumP1");
			FirefoxOptions option= new FirefoxOptions();
			option.setProfile(profile);
			driver= new FirefoxDriver(option);
			profile.setPreference("dom.webnotifications.enabled", false);
		}
	}
			
			
		
		public static void navigateUrl(String url)
		{
			driver.get(childProp.getProperty(url));
		}
		
		
		public static void typeText(String locatorKey, String text) 
		{
			getElement(locatorKey).sendKeys(text);
			//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);
		}
		public static void selectOption(String locatorKey, String option) 
		{
			getElement(locatorKey).sendKeys(option);
			//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
		}
		
		public static WebElement getElement(String locatorKey) 
		{
			WebElement element =null;
			
			if(locatorKey.endsWith("_id")) {
				element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_name")) {
				element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_classname")) {
				element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_css")) {
				element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_linktext")) {
				element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_partiallinktext")) {
				element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
			}
			
			return element;
			
		}
		
		
		public static void reportSuccess(String passMsg) 
		{
			test.log(LogStatus.PASS, passMsg);
		}
		public static void reportFailure(String failMsg) throws Exception 
		{
			test.log(LogStatus.FAIL, failMsg);
			screenshot();
		}
		public static void screenshot() throws Exception 
		{
			Date dt=new Date();
			System.out.println(dt);
			String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File(projectpath+"\\failurescreenshots\\"+dateFormat));
			
			test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectpath+"\\failurescreenshots\\"+dateFormat));
		}
		public static boolean isLinkEqual(String expectedLink) 
		{
			String actualLink = driver.findElement(By.xpath("//a[contains(text(),'New Releases')]")).getAttribute("innerHTML");
			if(actualLink.equals(expectedLink))
				return true;
			else
				return false;
		}
		
	}

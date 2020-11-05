package excelDataDriven;

import org.openqa.selenium.By;

import Mavenp.Maven2.Master1myself;

public class FacebookApi extends Master1myself
{

	public static void main(String[] args) throws Exception 
	{
		init1();
		Launch("chromebrowser");
		NavigateUrl("facebookurl");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Sept Drivers\\chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
		//driver1.manage().window().maximize();
	//	driver1.get("https://www.facebook.com");
		ExcelAPI e  = new ExcelAPI("C:\\Users\\nstar\\Desktop\\XML data.xlsx");

		for(int i=1;i<e.getRowCount("facebooklog");i++)
		{
			driver1.findElement(By.id("email")).clear();
			driver1.findElement(By.id("email")).sendKeys(e.getCellData("facebooklog", "Email", i));
			

			driver1.findElement(By.id("pass")).clear();
			driver1.findElement(By.id("pass")).sendKeys(e.getCellData("facebooklog", "Password", i));
			
			driver1.findElement(By.id("u_0_b")).click();

			Thread.sleep(14000);
			driver1.navigate().back();
		}



	}

}


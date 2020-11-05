package Mavenp.Maven2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class Test1 extends Master1myself
{
	private static final Logger log =Logger.getLogger(Test1.class);
	public static void main(String[] args) throws Exception 
	{
		
		init1();
		test1= report1.startTest("Test1");
		Launch("chromebrowser");
		NavigateUrl("amazonurl");
		driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("halloween");
		test1.log(LogStatus.INFO, "put halloween in searchbox");
		driver1.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]")).click();
		
	
	}

}

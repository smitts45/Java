

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Mavenp.Maven2.Basetest;

import excelDataDriven.ExcelAPI;



public class DataManagementUtil extends Basetest
{
  @Test(dataProvider = "getData")
  public void testCase(Hashtable<String, String> data) 
  {

  }

  @DataProvider
  public Object[][] getData() throws Exception
  {

	  ExcelAPI e = new ExcelAPI("C:\\Users\\nstar\\Desktop\\SuiteA.xlsx");
	  sheetName = "Data";
	  testName = "TestA";
	  return DataUtils.getTestData(e, sheetName, testName);

  }


}
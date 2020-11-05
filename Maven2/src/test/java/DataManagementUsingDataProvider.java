import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelDataDriven.ExcelAPI;

public class DataManagementUsingDataProvider 
{

  @Test(dataProvider = "getData")
  public void demoTest(String RunMode,String Browser, String UserName, String Pasword) 
  {

  }


  @DataProvider
  public Object[][] getData() throws Exception
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\nstar\\Desktop\\SuiteA.xlsx");
		String sheetName = "Data";
		String testCaseName = "TestB";

		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
		{
			testStartRowNum++;
		}
		System.out.println("Test Start from row : " + testStartRowNum);

		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;


		//calculate rows of Data
		int rows =0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are :- " + rows);


		//calculate total columns
		int cols=0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total columns are :- " + cols);


		//read the data
		int dataRow =  0;
		Object[][] data = new Object[rows][cols];
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				data[dataRow][cNum] = e.getCellData(sheetName, cNum, rNum);
			}
			dataRow++;
		}

	return data;

  }

}
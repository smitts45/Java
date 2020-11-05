

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelDataDriven.ExcelAPI;

public class DataManagementUsingHashTable 
{

  @Test(dataProvider = "getData")
  public void demoTest(Hashtable<String, String> data) 
  {

  }


  @DataProvider
  public Object[][] getData() throws Exception
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\nstar\\Desktop\\SuiteA.xlsx");
		String sheetName = "Data";
		String testCaseName = "TestA";

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
		Object[][] data = new Object[rows][1];
		Hashtable<String,String> table = null;

		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table = new Hashtable<String, String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				//data[dataRow][cNum] = e.getCellData(sheetName, cNum, rNum);
				String key = e.getCellData(sheetName, cNum, colStartRowNum);
				String value = e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}

	return data;

  }

}
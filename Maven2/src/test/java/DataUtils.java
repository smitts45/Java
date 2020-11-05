

import java.util.Hashtable;

import Mavenp.Maven2.Basetest;
import excelDataDriven.ExcelAPI;



public class DataUtils extends Basetest
{

	public static Object[][] getTestData(ExcelAPI e, String sheetName, String testName)
	{


			int testStartRowNum = 0;
			while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testName))
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
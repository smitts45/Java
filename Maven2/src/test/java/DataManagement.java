import excelDataDriven.ExcelAPI;

public class DataManagement 
{
	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e = new ExcelAPI("C:\\Users\\nstar\\Desktop\\SuiteA.xlsx");
		String sheetName = "Data";
		String testCaseName = "TestB";
		String testCaseName1 = "TestA";

		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName1))
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
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++)
			{
				System.out.println(e.getCellData(sheetName, cNum, rNum));
			}
		}
		
	}
}
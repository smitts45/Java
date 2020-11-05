package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderByColumnName
{

	public static void main(String[] args) throws Exception
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\nstar\\Desktop\\XML data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Infodata");
		XSSFRow	row=sheet.getRow(0);
		XSSFCell cell= null;
		
		int cellIndex = -1;
		
		for(int i=0; i <row.getLastCellNum(); i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("address"))
			cellIndex=i;
			
		}
		row= sheet.getRow(1);
		cell=row.getCell(cellIndex);
		
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		wb.close();
		fis.close();
	}

}

package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderByColumnNumber 
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\nstar\\Desktop\\XML data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Infodata");
		XSSFRow row = sheet.getRow(3);
		
		XSSFCell cell=row.getCell(0);
		 String value = cell.getStringCellValue();
		 System.out.print(value);
		 
		 XSSFCell cell1 =row.getCell(1);
		 String value1 = cell1.getStringCellValue();
		 System.out.print("   "+value1);
		 
		 XSSFCell cell2=row.getCell(2);
		   double value2 = cell2.getNumericCellValue();
		 System.out.print("   "+value2);
		 
		 XSSFCell cell3=row.getCell(3);
		 String value3 = cell3.getStringCellValue();
		 System.out.print("   "+value3);
		 
		XSSFSheet cell4= row.getSheet();
		String value4	=cell4.getSheetName();
		System.out.print("   "+value4);
		
		 
		 wb.close();
		 fis.close();
		 
		
		
		
	}

}

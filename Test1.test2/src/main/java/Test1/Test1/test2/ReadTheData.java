package Test1.Test1.test2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTheData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String Sheetname = "Demo";
		File f1 = new File("C:/Test1/Test1.test2/src/main/java/resources/Book1.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		Workbook wb =new XSSFWorkbook(fis);
		Sheet demo = wb.getSheet(Sheetname);
	//	System.out.println(demo.getSheetName());
		int rowCount = demo.getLastRowNum()-demo.getFirstRowNum();
		//int getfirstrow = demo.getFirstRowNum();
	//	System.out.println(getfirstrow);
		//Row r = demo.getRow(0);
		Iterator<Row> itr = demo.iterator();
		Row FirstRow =itr.next();
		Row SecondRow =itr.next();
		Iterator<Cell> ce = SecondRow.cellIterator();
		Cell cellValue = ce.next();
		Cell cellValue1 = ce.next();
		System.out.println(cellValue1.getStringCellValue());
		
		for(int i=0 ; i<rowCount+1 ; i++)
		{
			Row r = demo.getRow(i);
			//System.out.println(r);
			for(int j=0; j< r.getLastCellNum(); j++)
			{
				System.out.print(r.getCell(j).getStringCellValue()+"||");
				
			}
			System.out.println();
		}wb.close();

	}

}

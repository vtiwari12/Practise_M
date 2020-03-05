package Test1.Test1.test2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTheData {
	

	public static String[][] excelData() throws IOException {
		String Sheetname = "Demo";
		File f1 = new File(
				"C:/Test1/Test1.test2/src/main/java/resources/Book1.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet demo = wb.getSheet(Sheetname);

		int rowCount = demo.getLastRowNum() - demo.getFirstRowNum();

		Iterator<Row> itr = demo.iterator();
		Row SecondRow = itr.next();
		Iterator<Cell> ce = SecondRow.cellIterator();
		String[][] a1 = null;
		Row r= null;
		
		for (int i = 0; i < rowCount + 1; i++) {
			r = demo.getRow(i);
			
			a1 = new String[rowCount + 1][r.getLastCellNum()];

			for (int j = 0; j < r.getLastCellNum(); j++) {
				if(r.getCell(j).getCellType().equals(r.getCell(j).getCellType().STRING))
				{
				a1[i][j] = r.getCell(j).getStringCellValue();
				// System.out.print(r.getCell(j).getStringCellValue() + "||");
				// ls.add(r.getCell(j).getStringCellValue());

				System.out.println(a1[i][j]);
				}
				else if (r.getCell(j).getCellType().equals(r.getCell(j).getCellType().NUMERIC)){
					a1[i][j] = r.getCell(j).getStringCellValue();
				}
			}

			

		}
		wb.close();
		return a1;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		excelData();
	}

}

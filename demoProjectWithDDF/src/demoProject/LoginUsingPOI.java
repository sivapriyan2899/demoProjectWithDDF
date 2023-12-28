package demoProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class LoginUsingPOI {

	
	public void getExcelData() throws IOException {
		FileInputStream input = new FileInputStream("C:\\selenium\\rough notes\\login.xlsx");
		
		Workbook workbook = new XSSFWorkbook(input);
		
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		
		while(rowIterator.hasNext())
		{
			Row rowValue = rowIterator.next();
			//Iterator<column> columnIterator =	sheet.iterator();
			Iterator<Cell> columnIterator = rowValue.iterator();
			while(columnIterator.hasNext()) {
				Cell cellValue =columnIterator.next();
				System.out.println(cellValue);
			}
		}
		workbook.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LoginUsingPOI usingPOI = new LoginUsingPOI();
		usingPOI.getExcelData();
	}

}

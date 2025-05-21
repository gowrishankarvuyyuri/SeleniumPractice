package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_Data_From_File {

	public static void main(String[] args) throws IOException {
		
		String file_path = System.getProperty("user.dir")+"\\TestData\\Data.xlsx";
		
		//Reading the Excel File by launching FileInputStream Class
		FileInputStream file = new FileInputStream(file_path);
		
		//Creating an Workbook class object for extracting the sheet
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//Can choose out of 3 methods through getSheet, getSheetIndexAt, getSheetName
		XSSFSheet sheet = workbook.getSheet("Sheet4");
		
		//Getting the Number of Rows and cells
		int last_row = sheet.getLastRowNum();//LastRowNum will always starts with '0' as index
		int last_cell = sheet.getRow(last_row).getLastCellNum(); //LastCellNum will always starts with '1' as index
		
		System.out.println("Rows : " +last_row+ "\nCells : " + last_cell);
		
		//Iterating each row with cells
		for(int row = 1; row <= last_row; row++) {
			
			XSSFRow current_row = sheet.getRow(row);
			for(int col = 0; col < last_cell; col++) {
	
				XSSFCell current_cell = current_row.getCell(col);
				String cell_data = current_cell.toString();
				System.out.print(cell_data + "\t");
				
			}
			System.out.println();
		}
		
		workbook.close();
		file.close(); 
	}

}

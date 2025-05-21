package Data_Driven_Testing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writing_Data_To_File_Dynamically {

	public static void main(String[] args) throws IOException {
		
		String file_path = System.getProperty("user.dir")+"\\TestData\\Wrirting_Compile.xlsx";
		
		//writing to the file - if file exits it overides else it will create by own
		FileOutputStream file = new FileOutputStream(file_path);
		
		//creating a class for workbook and not giving any connection to file
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//creating a sheet with Name
		XSSFSheet sheet = workbook.createSheet("Sheet2");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Number of Rows? : " );
		int rows = scanner.nextInt();
		
		System.out.print("Enter Number of Coloumns? : " );
		int cols = scanner.nextInt();
		System.out.println();
		
		for(int r = 0; r <= rows; r++) {
			
			XSSFRow current_row = sheet.createRow(r);
			for(int c = 0; c <= cols; c++) {
				
				XSSFCell current_cell = current_row.createCell(c);
				System.out.print("Enter Data at Row " + r + " and Cell " + c + " : ");
				String Data = scanner.next();
				current_cell.setCellValue(Data);
			}
			System.out.println();
		}
		
		//ataching workbook to the file
		workbook.write(file);
		
		//closing objects
		workbook.close();
		file.close();

	}

}

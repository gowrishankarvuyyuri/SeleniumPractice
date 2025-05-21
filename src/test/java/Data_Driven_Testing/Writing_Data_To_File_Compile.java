package Data_Driven_Testing;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writing_Data_To_File_Compile {

	public static void main(String[] args) throws IOException {
		
		String file_path = System.getProperty("user.dir")+"\\TestData\\Wrirting_Compile.xlsx";
		
		//writing to the file - if file exits it overides else it will create by own
		FileOutputStream file = new FileOutputStream(file_path);
		
		//creating a class for workbook and not giving any connection to file
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//creating a sheet with Name
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		
		//Pointing out a row on SheetName
		XSSFRow row = sheet.createRow(0);
			//pointing out cell on each row
			row.createCell(0).setCellValue("Name");
			row.createCell(1).setCellValue("Branch");
			row.createCell(2).setCellValue("Age");
			
		XSSFRow row1 = sheet.createRow(1);
			row1.createCell(0).setCellValue("Gowri");
			row1.createCell(1).setCellValue("Attili");
			row1.createCell(2).setCellValue("24");
			
		XSSFRow row2 = sheet.createRow(2);
			row2.createCell(0).setCellValue("Divya");
			row2.createCell(1).setCellValue("Hyderabad");
			row2.createCell(2).setCellValue("28");
			
		//writing data from workbook to file
		workbook.write(file);
		
		//closing objects
		workbook.close();
		file.close();
	}

}

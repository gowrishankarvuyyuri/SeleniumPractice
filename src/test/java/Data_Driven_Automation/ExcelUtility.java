package Data_Driven_Automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtility {
	
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow wr;
	public static XSSFCell wc;

	
	public static void ClearFields(WebElement Amount, WebElement Length, WebElement Intrest) {
		
		Amount.clear();
		Length.clear();
		Intrest.clear();
	}

	public static int getRowNumbers(String path, String sheet_name) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet_name);
		wb.close();
		fi.close();
		return(ws.getLastRowNum());
	}
	
	public static int getCellNumbers(String path, String sheet_name, int row) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet_name);
		wr = ws.getRow(row);
		wb.close();
		fi.close();
		return(wr.getLastCellNum());
	}
	
	public static String getCellData(String path, String sheet_name, int row, int col) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet_name);
		String cell_data;
		try{
			/*
			wc = ws.getRow(row).getCell(col);
			cell_data = wc.toString();
			*/
			wc = ws.getRow(row).getCell(col);
			DataFormatter formatter = new DataFormatter();
			cell_data = formatter.formatCellValue(wc);

		}
		catch(Exception e) {
			cell_data = "";
		}
		wb.close();
		fi.close();
		return cell_data;
	}
}

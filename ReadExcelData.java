package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static String[][] readExcel() throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./testdata/tc001.xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		String[][] array = new String[rowCount][colCount];
		for(int i=1; i<=rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for(int j=0; j<colCount; j++) {
				XSSFCell eachCell = eachRow.getCell(j);
				String data = eachCell.getStringCellValue();
				array[i-1][j] = data;
			}
		}
		return array;
	}

}

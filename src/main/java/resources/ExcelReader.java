package resources;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.config.PropertyGetter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	public static Object[][] readExcel() throws IOException {
		FileInputStream fis = new FileInputStream(PropertyFileReader.loadFile().getProperty("excelFile"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet=null;
		
		ArrayList<String> data = new ArrayList<String>();
		
		for(int i=0;i<workbook.getNumberOfSheets();i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				 sheet = workbook.getSheetAt(i);
				break;
			}	
		}
		Iterator<Row> rows =  sheet.iterator();
		
	
		while(rows.hasNext()) {
			Row row = rows.next();   
			Iterator<Cell> cellItr = row.cellIterator();
			Cell cell = cellItr.next();
			
			if(cell.getStringCellValue().equalsIgnoreCase("Search")) {
				while(cellItr.hasNext()) {
					cell= cellItr.next();
					data.add(cell.getStringCellValue());
					System.out.println(cell.getStringCellValue());
				}
			}
			
		}
		workbook.close();
		Object[][] Data = new Object[data.size()][1];
		for(int i=0;i<data.size();i++) {
			Data[i][0]=data.get(i);
		}
		return Data;
	}

}

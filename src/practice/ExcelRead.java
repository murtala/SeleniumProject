package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelRead {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File excel = new File("src\\selenium\\Data.xls");
		FileInputStream fis = new FileInputStream(excel);

		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet ws = wb.getSheet("Sheet1");

		int rowNum = ws.getLastRowNum() + 1;// +1 to start reading from row1,
											// row 0 in the xcel sheet is just
											// the column names
		int colNum = ws.getRow(0).getLastCellNum();// total # of ceels

		
		String[][] data = new String[rowNum][colNum];

		
		HashMap m= new HashMap(rowNum,colNum);
	//	m.put(rowNum, colNum);
		System.out.println("*** " +m);
		
		for (int i = 0; i < rowNum; i++) {
			HSSFRow row = ws.getRow(i);
			for (int j = 0; j < colNum; j++) {
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);//convert the cell to String
				data[i][j] = value;
				System.out.print(" " + value);
				//System.out.println();
			}
		}

	}

	public static String cellToString(HSSFCell cell) throws Exception {
		int type;
		Object result;
		type = cell.getCellType();
		
		 switch(type) {
		    case 0://numeric value in excel
		        result = cell.getNumericCellValue();
		        break;
		    case 1: //string value in excel
		        result = cell.getStringCellValue();
		        break;
		    case 2: //boolean value in excel
		        result = cell.getBooleanCellValue ();
		        break;
		    default:
		        throw new Exception("There are not support for this type of   cell");
		        }

		return result.toString();
		}
	}



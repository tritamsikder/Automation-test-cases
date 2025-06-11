package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// Declare common variables for Excel file handling
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	// Method to get the number of rows in the specified sheet
	public static int getRowCount(String excelFile, String excelSheet) throws IOException {
		fi = new FileInputStream(excelFile); // Load file
		wb = new XSSFWorkbook(fi); // Open workbook
		ws = wb.getSheet(excelSheet); // Access the specified sheet
		int rowCount = ws.getLastRowNum(); // Get index of last row (0-based)
		wb.close();
		fi.close();
		return rowCount;
	}

	// Method to get the number of cells in a specific row
	public static int getCellCount(String excelFile, String excelSheet, int rowNum) throws IOException {
		fi = new FileInputStream(excelFile); // Load file
		wb = new XSSFWorkbook(fi); // Open workbook
		ws = wb.getSheet(excelSheet); // Access the specified sheet
		row = ws.getRow(rowNum); // Access the specified row
		int cellCount = row.getLastCellNum(); // Get number of cells in the row
		wb.close();
		fi.close();
		return cellCount;
	}

	// Method to get data from a specific cell as a string
	public static String getCellData(String excelFile, String excelSheet, int rowNum, int column) throws IOException {
		fi = new FileInputStream(excelFile); // Load file
		wb = new XSSFWorkbook(fi); // Open workbook
		ws = wb.getSheet(excelSheet); // Access the specified sheet
		row = ws.getRow(rowNum); // Access the specified row
		cell = row.getCell(column); // Access the specified cell

		String data;
		try {
			// Use DataFormatter to get cell value as string (formatted as in Excel)
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = ""; // Return empty string if any exception occurs (e.g., cell is null)
		}
		wb.close();
		fi.close();
		return data;
	}

	// Method to write data to a specific cell
	public static void setCellData(String excelFile, String excelSheet, int rowNum, int column, String data) throws IOException {
		fi = new FileInputStream(excelFile); // Load file
		wb = new XSSFWorkbook(fi); // Open workbook
		ws = wb.getSheet(excelSheet); // Access the specified sheet
		row = ws.getRow(rowNum); // Access the specified row
		cell = row.getCell(column); // Access the specified cell
		cell.setCellValue(data); // Set the new cell value
		fo = new FileOutputStream(excelFile); // Open file for writing
		wb.write(fo); // Write changes to file
		wb.close();
		fi.close();
		fo.close();
	}

	// Method to fill a cell with green color (e.g., to mark as "pass")
	public static void fillGreenColour(String excelFile, String excelSheet, int rowNum, int column) throws IOException {
		fi = new FileInputStream(excelFile); // Load file
		wb = new XSSFWorkbook(fi); // Open workbook
		ws = wb.getSheet(excelSheet); // Access the specified sheet
		row = ws.getRow(rowNum); // Access the specified row
		cell = row.getCell(column); // Access the specified cell

		style = wb.createCellStyle(); // Create a new cell style
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); // Set foreground color to green
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // Set fill pattern

		cell.setCellStyle(style); // Apply the style to the cell
		fo = new FileOutputStream(excelFile); // Open file for writing
		wb.write(fo); // Save changes
		wb.close();
		fi.close();
		fo.close();
	}

	// Method to fill a cell with red color (e.g., to mark as "fail")
	public static void fillRedColour(String excelFile, String excelSheet, int rowNum, int column) throws IOException {
		fi = new FileInputStream(excelFile); // Load file
		wb = new XSSFWorkbook(fi); // Open workbook
		ws = wb.getSheet(excelSheet); // Access the specified sheet
		row = ws.getRow(rowNum); // Access the specified row
		cell = row.getCell(column); // Access the specified cell

		style = wb.createCellStyle(); // Create a new cell style
		style.setFillForegroundColor(IndexedColors.RED.getIndex()); // Set foreground color to red
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // Set fill pattern

		cell.setCellStyle(style); // Apply the style to the cell
		fo = new FileOutputStream(excelFile); // Open file for writing
		wb.write(fo); // Save changes
		wb.close();
		fi.close();
		fo.close();
	}

}

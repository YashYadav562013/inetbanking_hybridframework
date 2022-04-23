package com.vandvtechsolution.inetbanking.Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public XSSFWorkbook workbook;

	public ExcelDataProvider(String fname) {
		try {
			File fs = new File(fname);
			FileInputStream fins = new FileInputStream(fs);
			workbook = new XSSFWorkbook(fins);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getStringCellValue(String sheetname, int row, int column) {
		return workbook.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringCellValue(int sheetindex, int row, int column) {
		return workbook.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	}

	public int getNumericCellValue(String sheetname, int row, int column) {
		return (int) workbook.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

	public int getNumericCellValue(int sheetindex, int row, int column) {
		return (int) workbook.getSheetAt(sheetindex).getRow(row).getCell(column).getNumericCellValue();
	}

	public Object[][] getExcelTestdata(String sheetname) {

		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		short colunmcount = sheet.getRow(0).getLastCellNum();
		System.out.println("total row count:"+rowcount);
		System.out.println("total cell count:"+colunmcount);

		Object[][] data = new Object[rowcount][colunmcount];

		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < colunmcount; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
}

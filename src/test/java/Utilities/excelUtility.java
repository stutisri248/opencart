package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;


public class excelUtility {
			public static FileInputStream fi;
			public static FileOutputStream fo;
			public static XSSFWorkbook wb;
			public static XSSFSheet sheet;
			public static XSSFCell cell;
			public static XSSFRow row;
			public static CellStyle style;
			
			public int getRow(String filename, String sheetname) throws Exception {
				FileInputStream fi = new FileInputStream(filename);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet(sheetname);
				int row = sheet.getLastRowNum();
				wb.close();
				fi.close();
				return row;
			}
			public  int getcell(String filename,String sheetName) throws Exception {
				FileInputStream fi = new FileInputStream(filename);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet(sheetName);
				int cell = sheet.getRow(0).getLastCellNum();
				wb.close();
				fi.close();
				return cell;
			}
			public  String getcelldata(String FileName, String sheetName, int rownum, int colnum) throws Exception {
				FileInputStream fi =  new FileInputStream(FileName);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet(sheetName);
				XSSFRow r = sheet.getRow(rownum);
				XSSFCell c = r.getCell(colnum);
				DataFormatter formatter = new DataFormatter();
				String data= formatter.formatCellValue(c);
				wb.close();
				fi.close();
				return data;
				
			}
			public static void setCellData(String file, int row, int col, String data, String sheetName) throws Exception {
				FileOutputStream fo = new FileOutputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook();
				XSSFSheet s = wb.createSheet(sheetName);
				XSSFRow r = s.createRow(row);
				r.createCell(col).setCellValue(data);
				wb.write(fo);
				wb.close();
				fo.close();
			}
			public static void setGreenColor(String file, int rownum, String sheetName, int cellnum) throws Exception {
				FileInputStream fi =  new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet(sheetName);
				row = sheet.getRow(rownum);
				cell = row.getCell(cellnum);
				style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell.setCellStyle(style);
					
				fo = new FileOutputStream(file);
				wb.write(fo);
				wb.close();
				fi.close();
				fo.close();
			}
			
			public static void setRedColor(String file, String sheetName, int rownum, int cellnum) throws Exception {
				FileInputStream fi =  new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet(sheetName);
				row = sheet.getRow(rownum);
				cell = row.getCell(cellnum);
				style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell.setCellStyle(style);
					
				fo = new FileOutputStream(file);
				wb.write(fo);
				wb.close();
				fi.close();
				fo.close();
			}
		}


package com.lee.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExcelUtils {
	private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);


	/**
	 * 解析03版excel
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @return
	 */
	public static List<Map<String,String>> getDataFromExcelXls(String filePath, String fileName){
		String[]columns ;
		FileInputStream fs;
		POIFSFileSystem ps ;
		HSSFWorkbook wb ;
		List<Map<String,String>> dataList = new ArrayList<Map<String, String>>();
		Map<String,String> map ;
		if (StringUtils.isNotEmpty(filePath) && StringUtils.isNotEmpty(fileName)){
			try{
				fs = new FileInputStream(filePath+fileName);  //获取d://test.xls
				ps = new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
				wb = new HSSFWorkbook(ps);
				if (fileName.endsWith(".xls")){
					for (int ii = 0; ii < 1; ii++) {
						HSSFSheet sheet = wb.getSheetAt(0);
						HSSFRow rowHead = sheet.getRow(0);
						columns = new String[rowHead.getPhysicalNumberOfCells()];
						for (int i = 0;i<rowHead.getPhysicalNumberOfCells();i++){
							columns[i] = rowHead.getCell(i).getStringCellValue();
						}
						Integer lastRowNum = sheet.getLastRowNum();
						HSSFRow row ;
						String cellValue ;
						if(ii==0){
							for(int index = 1;index <= lastRowNum;index++){
								map = new HashMap<String, String>();
								row =  sheet.getRow(index);
								for(int j=0;j<columns.length;j++){
									cellValue = getCellValue(row.getCell(j));
									map.put(columns[j],cellValue);
								}
								dataList.add(map);
							}
						}
					}
				}
			}catch(Exception e){
				logger.error("",e);
			}
		}
		return dataList;
	}

	/**
	 * 解析07版excel
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @return
	 */
	public static List<Map<String,String>> getDataFromExcelXlsx(String filePath, String fileName){
		String[]columns ;
		FileInputStream fs = null;
		XSSFWorkbook wb = null;
		List<Map<String,String>> dataList = new ArrayList<Map<String, String>>();
		Map<String,String> map ;
		if (StringUtils.isNotEmpty(filePath) && StringUtils.isNotEmpty(fileName)){
			try{
				fs = new FileInputStream(filePath+fileName);  //获取d://test.xls
				wb = new XSSFWorkbook(fs);
				if (fileName.endsWith(".xlsx")){
					for (int ii = 0; ii < 1; ii++) {
						Sheet sheet = wb.getSheetAt(0);
						Row rowHead = sheet.getRow(0);
						columns = new String[rowHead.getPhysicalNumberOfCells()];
						for (int i = 0;i<rowHead.getPhysicalNumberOfCells();i++){
							columns[i] = rowHead.getCell(i).getStringCellValue();
						}
						Integer lastRowNum = sheet.getLastRowNum();
						Row row ;
						String cellValue ;
						if(ii==0){
							for(int index = 1;index <= lastRowNum;index++){
								map = new HashMap<String, String>();
								row =  sheet.getRow(index);
								for(int j=0;j<columns.length;j++){
									cellValue = getCellValue(row.getCell(j));
									map.put(columns[j],cellValue);
								}
								dataList.add(map);
							}
						}
					}
				}
			}catch(Exception e){
				logger.error("",e);
			}
		}
		return dataList;
	}


	private static String getCellValue(Object cell){
		String cellValue = "";
		if (cell!=null){
			if (cell instanceof HSSFCell){
				HSSFCell temp = (HSSFCell)cell;
				if (temp.getCellType() == Cell.CELL_TYPE_NUMERIC && HSSFDateUtil.isCellDateFormatted(temp)){
					Date d = temp.getDateCellValue();
					cellValue = formatTime(d);
				}else{
					temp.setCellType(Cell.CELL_TYPE_STRING);
					cellValue =  temp.getStringCellValue().replace("\r","").replace("\n","");
				}
			}else if (cell instanceof Cell){
				Cell temp = (Cell)cell;
				if (temp.getCellType() == Cell.CELL_TYPE_NUMERIC && HSSFDateUtil.isCellDateFormatted(temp)){
					Date d = temp.getDateCellValue();
					cellValue = formatTime(d);
				}else{
					temp.setCellType(Cell.CELL_TYPE_STRING);
					cellValue =  temp.getStringCellValue().replace("\r","").replace("\n","");
				}
			}
		}
		return cellValue;
	}


	public static String formatTime(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
	}


	 public static void main(String[] args) {
//		 System.out.println(ExcelUtils.getDataFromExcelXls("C:\\Users\\jack\\Desktop\\","demo.xls"));
		 System.out.println(ExcelUtils.getDataFromExcelXlsx("C:\\Users\\jack\\Desktop\\","demo.xlsx"));

	 }
}

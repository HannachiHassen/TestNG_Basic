package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static List<Map<String, String>> getTestDetails(String sheetName) {
		FileInputStream fs = null;
		List<Map<String, String>> dataList=null;
		
		try {
			fs =new FileInputStream(System.getProperty("user.dir")+ "/resources/TestData.xlsx");
			XSSFWorkbook workbook= new XSSFWorkbook(fs);
			XSSFSheet sheet =workbook.getSheet(sheetName);		
			
			int lastrownum =sheet.getLastRowNum();
			System.out.println(lastrownum);
			
			int lastcolnum = sheet.getRow(0).getLastCellNum();
			System.out.println(lastcolnum);
			
			Map<String, String> data=null;
			dataList= new ArrayList<>();
			
			for (int i = 1; i <=lastrownum; i++) {
				data  = new HashMap<>();
				for(int j = 0; j<lastcolnum ; j++) {
					String fieldName = sheet.getRow(0).getCell(j).getStringCellValue();
					String fieldValue = sheet.getRow(i).getCell(j).getStringCellValue();
					data.put(fieldName, fieldValue);				
				}			
				dataList.add(data);			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(dataList);
		return dataList;		
	}	
	
	public static void main(String[] args) throws IOException {
 
		List<Map<String, String>> mapDataList = getTestDetails(System.getProperty("user.dir")+ "/resources/TestData.xlsx");
		
		for(int k = 0; k<mapDataList.size() ; k++){
			System.out.println("Data Set "+ (k+1) +" : ");
			for(String s: mapDataList.get(k).keySet()){
				System.out.println("Value of "+s +" is  : "+mapDataList.get(k).get(s));
			}
			System.out.println("========================================================");
		}		
	}
}

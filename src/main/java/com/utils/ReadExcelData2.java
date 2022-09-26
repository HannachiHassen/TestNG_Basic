package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData2 {

	private ReadExcelData2() {
	
	}
	
	public static List<Map<String, String>> getTestDetails(String sheetname) {
		FileInputStream fs = null;
		List<Map<String,String>> list = null;
		try {
			fs =new FileInputStream(System.getProperty("user.dir")+ "/resources/TestData.xlsx");
			XSSFWorkbook workbook= new XSSFWorkbook(fs);
			 XSSFSheet sheet =workbook.getSheet(sheetname);				
					
			 Map<String,String> datamap = null;
			 list = new ArrayList<>();
					
			 for(int i=1;i<=sheet.getLastRowNum();i++) {
				 datamap = new HashMap<>();
					for(int j=0;j< sheet.getRow(0).getLastCellNum();j++) {
						String key = getCellContent(workbook,sheetname, 0, j);
						String value = getCellContent(workbook,sheetname, i, j);
						datamap.put(key, value);
					}
					list.add(datamap);
			 }
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(fs)) {
				try {
					fs.close();				
			   }catch (IOException e) {
					e.printStackTrace();
		       }
		     }
		}
		return list;
	  }

	private static String getCellContent(XSSFWorkbook workbook,String sheetname,int rownum, int colnum) {
		return workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).getStringCellValue();
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

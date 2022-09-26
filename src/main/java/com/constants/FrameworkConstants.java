package com.constants;

public final class FrameworkConstants {
	
    private FrameworkConstants() {}
	
    private static final int EXPLICITWAIT = 10;
    
    private static final String RESOURCESPATH= System.getProperty("user.dir") +"/resources/";
    
	private static final String CHROMEDRIVERPATH= RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH= RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH= RESOURCESPATH + "/config/config.properties";
	private static final String JSONCONFIGFILEPATH= RESOURCESPATH + "/jsons/config.json";
	private static final String EXCELFILEPATH= RESOURCESPATH + "/excel/testdata.xlsx";
	
	private static final String RUNMANGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	
		
	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH ;
	}
	
	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}	

	public static String getJsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}
	
	public static String getExcelFilePath() {
		return EXCELFILEPATH;
	}
	
	public static String getRunmangerDatasheet() {
		return RUNMANGERSHEET;
	}

	public static String getIterationDatasheet() {
		return ITERATIONDATASHEET;
	}
}

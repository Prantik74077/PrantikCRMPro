package com.commonlib;

public interface AutoConstant  
{
      String key1="webdriver.chrome.driver";
      String value1="./src/main/resources/chromedriver.exe";
      
      String key2="webdriver.gecko.driver";
      String value2="./src/main/resources/geckodriver.exe";
      
      String currentdirpath=System.getProperty("user.dir");
      String propertyfilepath=currentdirpath+"/src/test/resources/propertydata.properties";
      String excelpath=currentdirpath+"/src/test/resources/exceldata.xlsx";
      String screenshotpath="./Screenshot/";
      
      public int implicitlyWait=20;
      public int explicitlyWait=30;
}

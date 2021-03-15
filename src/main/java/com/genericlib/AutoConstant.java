package com.genericlib;

public interface AutoConstant  
{
      String key1="webdriver.chrome.driver";
      String value1="./src/main/resources/chromedriver.exe";
      
      String key2="webdriver.gecko.driver";
      String value2="./src/main/resources/geckodriver.exe";
      
      String currentdirpath=System.getProperty("user.dir");
      String propertyfilepath=currentdirpath+"/src/test/resources/data1.properties";
      String excelpath=currentdirpath+"/src/test/resources/Exceldata3.xlsx";
      String screenshotpath="./Screenshot/";
      
      public int implicitlyWait=20;
      public int explicitlyWait=30;
}

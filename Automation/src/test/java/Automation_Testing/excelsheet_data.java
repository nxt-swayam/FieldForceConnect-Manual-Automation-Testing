package Automation_Testing;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
public class excelsheet_data{
    public static void dataread(WebDriver d) throws Exception {
    	File f = new File("C:/Users/HP/Desktop/Nimap_Infotech/TestData.xlsx");
        FileInputStream fp = new FileInputStream(f);
        Workbook wb = new XSSFWorkbook(fp);
        XSSFSheet sh1 = (XSSFSheet) wb.getSheet("Data"); 
        XSSFSheet sh2 = (XSSFSheet) wb.getSheet("words"); 

        for(int i=0; i<=sh1.getLastRowNum(); i++)
        {
            if(sh1.getRow(i)==null) continue;                                 

            String us = "";                                                    
            String ps = "";
            if(sh1.getRow(i).getCell(0)!=null) us = sh1.getRow(i).getCell(0).getStringCellValue();
            if(sh1.getRow(i).getCell(1)!=null) ps = sh1.getRow(i).getCell(1).getStringCellValue();
            if(us.isEmpty() && ps.isEmpty()) continue;                           

            System.out.println(us + " " + ps);
            System.out.println("======================");

            for(int j=0; j<=sh2.getLastRowNum(); j++)
            {
                String keys = sh2.getRow(j).getCell(0).getStringCellValue();

                System.out.println(keys);

                if(keys.equalsIgnoreCase("OpenURL"))
                {
                    data_fetch.open(d);
                }

                if(keys.equalsIgnoreCase("UserName"))
                {
                	data_fetch.un(d, us);
                }
                if(keys.equalsIgnoreCase("Password"))
                {
                	data_fetch.ps(d, ps);
                }
                if(keys.equalsIgnoreCase("Login"))
                {
                	data_fetch.btn1(d);
                }
            }

            Thread.sleep(3000);                                                  
            System.out.println("URL after login: " + d.getCurrentUrl());    
            System.out.println("Page title: " + d.getTitle());
            if(d.getCurrentUrl().toLowerCase().contains("dashboard"))
                System.out.println("RESULT: PASS - login successful");
            else
                System.out.println("RESULT: CHECK - still on login page or different page");
            System.out.println();
        }

        wb.close();                                                         
        fp.close();
    }
}
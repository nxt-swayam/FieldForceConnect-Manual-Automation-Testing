package Automation_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browser {
    public static void main(String[] args) throws Exception {
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        try {
            excelsheet_data.dataread(d);
        } finally {
            d.quit();
        }
    }
}
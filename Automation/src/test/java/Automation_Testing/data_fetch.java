package Automation_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class data_fetch
{
    public static void open(WebDriver d)
    {
        d.get("https://test.fieldforceconnect.com/");
    }

    public static void un(WebDriver d, String u)
    {
        d.findElement(By.xpath("(//input[not(@type='password')])[1]")).sendKeys(u);
    }
    public static void ps(WebDriver d, String p)
    {
        d.findElement(By.xpath("//input[@type='password']")).sendKeys(p);
    }
    public static void btn1(WebDriver d)
    {
        d.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
    }

}
package com.crm.Vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerLoginLogoutTest {
	@Test
	public void loginLogout()
	{
		WebDriver driver=null;
		if (System.getProperty("browser").contains("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(System.getProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(System.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(System.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		WebElement signoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act =new Actions(driver);
		act.moveToElement(signoutButton).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}

package com.crm.Vtiger.Practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadTest {
	@Test
	public void lead() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		Random random=new Random();
		int ranNum = random.nextInt(10000);
		driver.findElement(By.name("lastname")).sendKeys("MavenProject"+ranNum);
		driver.findElement(By.name("company")).sendKeys("TestYantra");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     WebElement signoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act =new Actions(driver);
		act.moveToElement(signoutButton).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}



}

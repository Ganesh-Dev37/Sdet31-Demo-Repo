package com.crm.Vtiger.Practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
	@Test
	public void organization() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Random random=new Random();
		int ranNum = random.nextInt(10000);
		driver.findElement(By.className("detailedViewTextBox")).sendKeys("MavenProject"+ranNum);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("dvHeaderText"))));
	     WebElement signoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act =new Actions(driver);
		act.moveToElement(signoutButton).perform();

		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}

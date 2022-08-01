package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentManager.ExtentManager;

import basePackage.BaseClass;

public class OrangeHRM extends BaseClass {
	 @Test
	public void loginpage() {
		WebElement imgElement = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		Assert.assertTrue(imgElement.isDisplayed());
	}
	 @Test
	public void  logintest() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		String actualtitle = driver.getTitle();
		String expectltitle = "OrangeHRM1";
		Assert.assertEquals(actualtitle, expectltitle); 
	}

	 @Test
	 public void sampleCase() {
	  ExtentManager.test.createNode("Validation1");
	  Assert.assertTrue(true);
	  ExtentManager.test.createNode("Validation2");
	  Assert.assertTrue(true);
	  ExtentManager.test.createNode("Validation3");
	  Assert.assertTrue(true);
	  ExtentManager.test.createNode("Validation4");
	  Assert.assertTrue(true);
	 }
	}

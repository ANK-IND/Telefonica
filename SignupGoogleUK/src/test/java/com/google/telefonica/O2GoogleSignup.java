package com.google.telefonica;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class O2GoogleSignup {

	public WebDriver driver;
	String URL = "https://www.google.co.uk/";
	Comp_O2GoogleLogin_UI objCA = new Comp_O2GoogleLogin_UI();

	@BeforeTest
	public void initDriver() throws Exception {
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	@Test
	public void googleCreateAccount() {
		driver.get(URL);
		String currentURL = driver.getCurrentUrl();
		if (URL.equals(currentURL)) {
		System.out.println("Navigation to " + URL + "  is Successful");
		} else {
		System.out.println("Navigation to " + URL + " Failed");
		}
		driver.findElement(By.xpath(objCA.lnkGmail)).click();
		driver.findElement(By.xpath(objCA.lnkCreateAccount)).click();
		driver.findElement(By.id(objCA.txtFirstName_ID)).sendKeys("Telefonica");
		driver.findElement(By.id(objCA.txtLastName_ID)).sendKeys("O2");
		driver.findElement(By.id(objCA.txtUserName_ID)).sendKeys("");
		driver.findElement(By.id(objCA.txtCreatePwd_ID)).sendKeys("Sample123");
		driver.findElement(By.id(objCA.txtConfirmPwd_ID)).sendKeys("Sample123");
		WebElement gender = driver.findElement(By.xpath(objCA.ddGender_ID));
		gender.sendKeys("Male");
		WebElement birthday = driver.findElement(By.xpath(objCA.ddMonth_XPATH));
		birthday.sendKeys("August");
		driver.findElement(By.id(objCA.txtDay_ID)).sendKeys("21");
		driver.findElement(By.id(objCA.txtYear_ID)).sendKeys("1988");
		driver.findElement(By.id(objCA.txtPhoneNO_ID)).sendKeys("9176181813");
		driver.findElement(By.id(objCA.txtCurrentEmail_ID)).sendKeys("Ajava64@gmail.com");
		driver.findElement(By.id(objCA.chkVerification_ID)).click();
		driver.findElement(By.id(objCA.chkTermsConditions_ID)).click();
		driver.findElement(By.id(objCA.btnNextStep_ID)).click();
		WebElement usrError = driver.findElement(By.id(objCA.msgError_ID));
		String errormsg = usrError.getText();
		if (usrError.isDisplayed()) {
		System.out.println("Expected Error Message:" + errormsg + "displayed successfully");
		} else {
		System.out.println("Expected Error Message:" + errormsg + " not displayed ");
			}
		}

	@AfterTest
	public void quitDriver() throws Exception {
		driver.quit();
	}

}


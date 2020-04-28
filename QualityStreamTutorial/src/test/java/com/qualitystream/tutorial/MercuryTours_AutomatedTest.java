package com.qualitystream.tutorial;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;

	//elementos de la página de Register
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");

	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.xpath("//input[@name='confirmPassword']");

	By registerBtnlocator = By.name("register");

	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("login");

	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");

			driver.findElement(registerBtnlocator).click();

		} else {
			System.out.println("Register pages was not found");
		}

//		List<WebElement> fonts = driver.findElement(By.tagName("font"));
//
//		Assert.assertEquals(" Note: Your user name is qualityadmin.", fonts.get(5).getText());

	}
	
	@Test 
	public void signIn() throws InterruptedException {
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("qualityadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(homePageLocator).isDisplayed());
		}
		else {
			System.out.println("username textbox was not present");
		}
	}

}

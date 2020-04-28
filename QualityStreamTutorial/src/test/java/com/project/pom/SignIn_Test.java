package com.project.pom;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class SignIn_Test {

	private WebDriver driver;
	SignInPage signInPage;
	
	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		signInPage.signIn();
		Thread.sleep(2000);
		Assert.assertTrue(signInPage.isHomePageDisplyed());
	}

}

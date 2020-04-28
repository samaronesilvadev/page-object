package com.qualitystream.tutorial;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class GoogleSearchTest {

	private WebDriver driver;
	By videoLinkLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.clear();
		
		searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software - Google Search");
		
		searchBox.submit();
		
		//Implicit Wait
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Explicit Wait
//		WebDriverWait ewait = new WebDriverWait(driver, 10);
//		ewait.until(ExpectedConditions.titleContains("quality-stream"));
		
		//FluentWait 
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement video = fwait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(videoLinkLocator);
			}
		});
		
		Assert.assertTrue(driver.findElement(videoLinkLocator).isDisplayed());
		
//		Assert.assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Google Search - Pesquisa Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
//		driver.quit();
	}
}

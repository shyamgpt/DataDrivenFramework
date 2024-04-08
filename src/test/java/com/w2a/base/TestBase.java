package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	/*
	 * WebDriver Properties Logs Extent Report DB connection Excel reading Mail
	 * WebDriver - Done
	 * Properties -Done
	 * Logs -log4j jar
	 * Extent Report
	 * DB
	 * Excel
	 * Mail
	 * ReportNG, Extent Report
	 * Jenkins
	 * 
	 * 
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file Loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\ObjectRepository.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("Config file Loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
			}

			if (config.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.debug("Chrome launched !!!");
			}

			driver.get(config.getProperty("testsitrurl"));
			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(config.getProperty("implicit.wait"), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

		}
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
			
			
		}catch(NoSuchElementException e){
			return false;
		}
	}
	

	@AfterSuite
	public void tearDown() {

//		if (driver != null) {
//			driver.quit();
//		}

	}

}

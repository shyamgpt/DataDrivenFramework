package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		// This will give the path of current directory
		System.out.println(System.getProperty("user.dir"));
		
		// This will read the config properties file -->
		Properties config = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
        config.load(file);
        
//        System.out.println(config.getProperty("browser"));
        
        
     // This will read the Object Repository properties file -->
        Properties OR = new Properties();
        FileInputStream  ORfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ObjectRepository.properties");
        OR.load(ORfile);
//        System.out.println(OR.getProperty("bmLBtn"));
//        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
	}

}

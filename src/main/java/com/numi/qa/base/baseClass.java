package com.numi.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class baseClass {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebDriverWait w;
	public static Properties prop;
	public static Properties tdOnb;

	public baseClass() {
		try {
			String location = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\numi\\config\\config.properties";
			String location2 = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\td_onboard.properties";
			FileInputStream fis = new FileInputStream(location);
		FileInputStream fis2 = new FileInputStream(location2);
			
			prop = new Properties();
			tdOnb = new Properties();
			prop.load(fis);
		prop.load(fis2);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Driver\\chromeDriver83\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("", "");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		w = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;
		

	}
	
	public void waitForPageLoad(JavascriptExecutor js) {
		System.out.println("In the method of wait for page load");
		while (!js.executeScript("return document.readyState").toString().equals("complete")) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Page load was successful");
	}
	
	
	

}

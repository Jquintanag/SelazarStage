package uk.co.selazarlabs.stage;


import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelazarUploadOrder {
	
	
	@Test
	public void Login(){
		// Create driver
		WebDriver driver = new ChromeDriver();
		System.out.println("Test Started");
		sleep(2);
		
		// Create wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		// open page
		String url = "https://stage.selazar-labs.co.uk/";
		driver.get(url);
		driver.manage().window().maximize();
		sleep(2);

		// Enter user
		WebElement username = driver.findElement(By.xpath("/html//input[@id='email']"));
		username.sendKeys("selazarbot+apiupdate1@gmail.com");
		sleep(2);

		// Enter password
		WebElement password = driver.findElement(By.xpath("/html//input[@id='password']"));
		password.sendKeys("Password1*");
		sleep(2);

		// click on login
		WebElement LogInButton = driver.findElement(By.xpath("/html//div[@id='root']//form/button[@type='submit']"));
		LogInButton.click();
		sleep(2);
		
		//Click on Orders
		WebElement OrdersButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']//div[@href='/retailer/orders']")));
	    OrdersButton.click();
	    sleep(2);
	    
	    //Click on Upload order
	    WebElement UploadOrderButton =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li:nth-of-type(7) > a")));
	    UploadOrderButton.click();	    
	    sleep(2);
	    
	    //Click on Browse
	    WebElement BrowseButton =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".file-upload.text-center > .btn.btn-secondary")));
	    BrowseButton.click();	    
	    sleep(2);
	    
	    //Find the file
	    WebElement fileInput = driver.findElement(By.cssSelector(".file-upload.text-center > .btn.btn-secondary")); // Replace with the actual ID of the file input element
	    String filepath = "C:\\Users\\Juan Jo\\eclipse-workspace\\SelazarStage\\.\\1002csv.csv";
	    fileInput.sendKeys(filepath);
	    //System.out.println(file.getAbsolutePath());
	    //fileInput.sendKeys(file.getAbsolutePath());
	    
	    //Click Upload button

	    
	    //Close the driver
	    //driver.quit();
	}

	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

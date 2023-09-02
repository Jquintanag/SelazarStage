package uk.co.selazarlabs.stage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SelazarUploadOrder {
	
	
	@Test
	public void Login() throws AWTException  {
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
	    
	    
	    Robot robot = new Robot();
	    String filePath = "C:\\Users\\Juan Jo\\Documents\\orders\\1002csv.csv";
	    WebElement fileInput = driver.findElement(By.cssSelector(".file-upload.text-center > .btn.btn-secondary"));
	    fileInput.click();
	    
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    StringSelection stringSelection = new StringSelection(filePath);
	    clipboard.setContents(stringSelection, null);
	   
	    robot.delay(1000); // Delay to ensure the clipboard content is ready
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    WebElement ClickUploadButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
	    ClickUploadButton.click();
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

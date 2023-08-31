package uk.co.selazarlabs.stage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class SelazarCheckOrder {
	
	public void Login() {
	//Create driver
	WebDriver driver = new ChromeDriver();
	System.out.println("Test Started");
	sleep(1);
	
	//Create wait
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	//open page
	String url = "https://stage.selazar-labs.co.uk/";
	driver.get(url);
	driver.manage().window().maximize();
	sleep(1);
	
	//Enter username
	WebElement username = driver.findElement(By.xpath("/html//input[@id='email']"));
	username.sendKeys("selazarbot+apiupdate1@gmail.com");
	sleep(1);
	
	//Enter password
	WebElement password = driver.findElement(By.xpath("/html//input[@id='password']"));
	password.sendKeys("Password1*");
	sleep(1);
	
	//click on login
	WebElement LogInButton = driver.findElement(By.xpath("/html//div[@id='root']//form/button[@type='submit']"));
	LogInButton.click();
	sleep(1);
	
	//Click on orders
	WebElement OrdersButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']//div[@href='/retailer/orders']")));
    OrdersButton.click();
	
	//Click on AllOrders
    WebElement AllOrdersButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']/div[@class='content-wrapper']/div[@class='container-fluid']//nav/ol[@class='breadcrumb']//a[@href='/retailer/orders/allorders']")));
    AllOrdersButton.click();
    sleep(3);
    
	//Search the order 
	String OrderNumber = "#1001";
    WebElement SearchOrder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//input[@id='OrderSearchText']")));
	SearchOrder.sendKeys(OrderNumber);
	
	}
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}catch(InterruptedException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

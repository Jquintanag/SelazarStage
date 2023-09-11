package uk.co.selazarlabs.stage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelazarViewInvoicing {
	@Test
	public void viewInvoice() {
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
				
				//Click on Invoicing
				WebElement InvoicingButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sidebar-wrapper > div:nth-of-type(3)")));
				InvoicingButton.click();
				sleep(2);
				
				//Search a Invoice 
				WebElement SearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#invoiceNumberField")));
				SearchBar.sendKeys("INV1018324");
				sleep(2);
				
				//Click view invoice
				WebElement ViewInvoiceButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tr:nth-of-type(1) > .py-2.text-center > .btn.btn-secondary.btn-sm")));
				ViewInvoiceButton.click();
				sleep(2);
				

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

package uk.co.selazarlabs.stage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelazarCheckCourierPreferences {
	@Test
	public void CheckSettings() {
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
		
		//Click on Preferences
		WebElement ClickPreferences = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sidebar-wrapper > div:nth-of-type(12)")));
		ClickPreferences.click();
		sleep(2);
		
		//Mark Evri checkbox
		WebElement EvriCheckBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div:nth-of-type(1) > .custom-checkbox.custom-control.form-group.mb-2 > .custom-control-label.form-label")));
		if(EvriCheckBox.isSelected()){
			
		}else {
			EvriCheckBox.click();
		}
		
		//CLICK ON SAVE
		WebElement SaveButton = driver.findElement(By.cssSelector("form > .btn.btn-primary.float-right.mt-3"));
		SaveButton.click();
		
		//Verify the option of SFP
		WebElement RegionalButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li:nth-of-type(2) > a")));
		RegionalButton.click();
		
		WebElement SFP = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div:nth-of-type(2) > .switch > .round.slider")));
		if(SFP.isEnabled()) {
			SFP.click();
		}
		
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

package uk.co.selazarlabs.stage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelazarViewUser {
	@Test
	public void Login() {
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

		// Click On Users
		WebElement UsersButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']//div[@href='/company/users']")));
		UsersButton.click();
		sleep(2);
		
		//Click On viewUser
		WebElement ViewUserButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']/div[@class='content-wrapper']/div[@class='container-fluid']/div[@class='p-4 row']/div[@class='col-lg-12']//div[@class='container-fluid']//table//a[@href='/company/users/account/1077d77a-afa8-434d-d393-08db8791efc0']")));
		ViewUserButton.click();
		sleep(2);
		
		WebElement goBacktoUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']/div[@class='content-wrapper']/div[@class='container-fluid']/div[@class='p-4 row']//a[@href='/company/users']")));
		goBacktoUser.click();
		sleep(2);
		//Click on 3 dots
		WebElement threeDotsClick = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']/div[@class='content-wrapper']/div[@class='container-fluid']/div[@class='p-4 row']/div[@class='col-lg-12']//div[@class='container-fluid']/div[@class='mt-4 row']//table//div[@class='action-container']/div/button[@type='button']")));
		threeDotsClick.click();
		sleep(2);
		
		//Edit details
		WebElement EditDetails = driver.findElement(By.xpath("/html//div[@id='root']/div[@class='content-wrapper']/div[@class='container-fluid']/div[@class='p-4 row']/div[@class='col-lg-12']//div[@class='container-fluid']//table//div[@class='dropdown-menu show']/a[1]/button[@type='button']"));
		EditDetails.click();
		sleep(2);
		
		//edit name
		WebElement ForenameChange = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#forename")));
		ForenameChange.clear();
		ForenameChange.sendKeys("BotSelazar");
		sleep(2);
		
		//Click on cancel
		WebElement CancelButton = driver.findElement(By.cssSelector("[class='button-nav-link float-right mr-4 mt-1 btn btn-link']"));
		CancelButton.click();
		sleep(3);
		
		//close driver
		driver.quit();
		
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

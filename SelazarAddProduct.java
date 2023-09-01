package uk.co.selazarlabs.stage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelazarAddProduct {
	@Test
	public void AddProduct() {
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
				
				//Click On products
				WebElement ProductsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sidebar-wrapper > div:nth-of-type(6)")));
				ProductsTab.click();
				sleep(2);
				
				//Click on add product	
				WebElement addproductButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li:nth-of-type(2) > a")));
				addproductButton.click();
				sleep(2);
				
				//AddProductName
				String ProductName = "Camiseta Nike";
				WebElement EnterProductName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#nameField")));
				EnterProductName.sendKeys(ProductName);
				sleep(2);
				
				//Add Description 
				String ProductDescription = "Camiseta de algodon negra";
				WebElement EnterProductDescription = driver.findElement(By.cssSelector("textarea#descriptionField"));
				EnterProductDescription.sendKeys(ProductDescription);
				sleep(2);
				
				//Add Brand
				String BrandProduct = "Nike";
				WebElement EnterBrandProduct = driver.findElement(By.cssSelector("input#brandField"));
				EnterBrandProduct.sendKeys(BrandProduct);
				sleep(2);
				
				//Select Category
				WebElement SelectCategory = driver.findElement(By.cssSelector("select#categoryField"));
				SelectCategory.click();				
				Select select = new Select(SelectCategory);
				select.selectByVisibleText("Sporting Goods");
				sleep(2);
				
				//Click on NextStep
				WebElement NextStepButton = driver.findElement(By.cssSelector(".btn.btn-primary")); 
				NextStepButton.click();
				sleep(2);
				//.btn.btn-primary
				//Product Height
				WebElement EnterProductHeight = driver.findElement(By.cssSelector("input#heightField"));
				EnterProductHeight.clear();
				EnterProductHeight.sendKeys("15");
				sleep(2);
				
				//Product width
				WebElement EnterProductWidth = driver.findElement(By.cssSelector("input#widthField"));
				EnterProductWidth.clear();
				EnterProductWidth.sendKeys("15");
				sleep(2);
				
				//Product Depth
				WebElement EnterProductDepth = driver.findElement(By.cssSelector("input#depthField"));
				EnterProductDepth.clear();
				EnterProductDepth.sendKeys("15");
				sleep(2);
				
				//Product Weight
				WebElement EnterProductWeight = driver.findElement(By.cssSelector("input#weightField"));
				EnterProductWeight.clear();
				EnterProductWeight.sendKeys("1");
				sleep(2);
				
				//Select Manufacturing
				WebElement SelectManufacturing = driver.findElement(By.cssSelector("select#countryOfManufactureField"));
				SelectManufacturing.click();				
				Select select2 = new Select(SelectManufacturing);
				select2.selectByVisibleText("Colombia");
				sleep(2);
				
				//enter commodity code
				WebElement EnterProductCommodityCode= driver.findElement(By.cssSelector("input#commodityCodeField"));
				EnterProductCommodityCode.sendKeys("000000008");
				sleep(2);
				
				//Click on next Step
				NextStepButton.click();
				sleep(2);
				
				//Enter Product price
				WebElement EnterProductPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#priceField")));
				EnterProductPrice.clear();
				EnterProductPrice.sendKeys("7.99");
				sleep(2);
				
				//Enter Expected weekly sales 
				WebElement EnterWeeklySales = driver.findElement(By.cssSelector("input#expectedWeeklySalesField"));
				EnterWeeklySales.clear();
				EnterWeeklySales.sendKeys("5");
				sleep(2);
				
				//Click on next Step
				NextStepButton.click();
				sleep(2);
				
				//Add Sku
				WebElement AddSkuButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button#addSku")));
				AddSkuButton.click();
				sleep(2);
				
				//Enter SKU
				WebElement EnterSku = driver.findElement(By.cssSelector("input#skuCodeField"));
				EnterSku.sendKeys("RED-01");
				sleep(2);
				
				//Enter sku description
				WebElement EnterDescription = driver.findElement(By.cssSelector("input#descriptionField"));
				EnterDescription.sendKeys("RED-01 Black");
				sleep(2);
				
				//Click OK to save the changes
				WebElement ClickOk = driver.findElement(By.cssSelector("button#submit-sku-button"));
				ClickOk.click();
				sleep(2);
				
				//Enter EAN
				WebElement EnterEAN  = driver.findElement(By.cssSelector("input#eanField"));
				EnterEAN.sendKeys("5687234913854");
				sleep(2);
				
				//Click on next Step

				WebElement NextStepButton2 = driver.findElement(By.cssSelector(".float-right > .btn.btn-primary"));
				NextStepButton2.click();
				
				//Click on next Step
				WebElement NextStepButton3 = driver.findElement(By.cssSelector(".btn.btn-primary"));
				NextStepButton3.click();
				sleep(2);
				
				WebElement ClickCancel = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".link-button > .btn.btn-link.button-nav-link.mr-3")));
				ClickCancel.click();
				sleep(2);
				
				
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

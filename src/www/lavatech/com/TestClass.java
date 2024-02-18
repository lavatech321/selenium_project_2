package www.lavatech.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {
	
	WebDriver driver;
	
	@BeforeTest
	public void connectSite() {
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
	}
	
	@Parameters({"username","password"})
	@Test(priority=0)
	public void signUp(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		WebElement signup = driver.findElement(By.linkText("Sign up"));
		signup.click();
		Thread.sleep(2000);
		
		WebElement username1 = driver.findElement(By.id("sign-username"));
		username1.sendKeys(username);
		Thread.sleep(2000);
		WebElement password1 = driver.findElement(By.id("sign-password"));
		password1.sendKeys(password);
		Thread.sleep(2000);
		
		WebElement signin = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/button[2]"));
		signin.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);		
	}
	
	@Parameters({"username","password"})
	@Test(priority=1)
	public void login(String username, String password) throws InterruptedException {

		WebElement login = driver.findElement(By.id("login2"));
		login.click();
		Thread.sleep(2000);

		WebElement username1 = driver.findElement(By.id("loginusername"));
		username1.sendKeys(username);
		Thread.sleep(2000);
		
		WebElement password1 = driver.findElement(By.id("loginpassword"));
		password1.sendKeys(password);
		Thread.sleep(2000);
		
		WebElement logIn = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[3]/button[2]"));
		logIn.click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void cart() throws InterruptedException {
		WebElement add_cart1 = driver.findElement(By.partialLinkText("Samsung galaxy s6"));
		add_cart1.click();
		Thread.sleep(2000);

		WebElement add_to_cart1 = driver.findElement(By.linkText("Add to cart"));
		add_to_cart1.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement home = driver.findElement(By.partialLinkText("Home"));
		home.click();
		Thread.sleep(2000);
		
		WebElement add_cart2 = driver.findElement(By.partialLinkText("Nokia lumia 15") );
		add_cart2.click();
		Thread.sleep(2000);
		
		WebElement add_to_cart2 = driver.findElement(By.linkText("Add to cart"));
		add_to_cart2.click();
		Thread.sleep(2000);
		
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		Thread.sleep(2000);
		
		driver.get("https://www.demoblaze.com/cart.html");
		Thread.sleep(2000);
		
	}
	
	@Test(priority=3)
	public void placeOrder() throws InterruptedException {
		WebElement placeorder = driver.findElement(By.xpath("//body[1]/div[6]/div[1]/div[2]/button[1]"));
		placeorder.click();
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		name.sendKeys("Dummy");
		Thread.sleep(2000);
		
		WebElement country = driver.findElement(By.id("country"));
		country.sendKeys("India");
		Thread.sleep(2000);
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Pune");
		Thread.sleep(2000);
		
		WebElement card = driver.findElement(By.id("card"));
		card.sendKeys("DCXSZX1274");
		Thread.sleep(2000);
		
		WebElement month = driver.findElement(By.id("month"));
		month.sendKeys("06");
		Thread.sleep(2000);
		
		WebElement year = driver.findElement(By.id("year"));
		year.sendKeys("2023");
		Thread.sleep(2000);
		
		WebElement purchase = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[3]/button[2]"));
		purchase.click();
		Thread.sleep(2000);
		
		WebElement ok = driver.findElement(By.xpath("//body[1]/div[10]/div[7]/div[1]/button[1]"));
		ok.click();
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void contactUs() throws InterruptedException {
		
		WebElement contact = driver.findElement(By.linkText("Contact"));
		contact.click();
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.id("recipient-email"));
		email.sendKeys("dummy@gmail.com");
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.id("recipient-name"));
		name.sendKeys("Dummy User");
		Thread.sleep(2000);
		
		WebElement text = driver.findElement(By.id("message-text"));
		text.sendKeys("When can I get the product delivered?");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void closeSite() {
		driver.quit();
	}
	
}

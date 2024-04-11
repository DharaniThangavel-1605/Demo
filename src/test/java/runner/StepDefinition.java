package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
	@Given ("Click on Shop now")
	public void clickOnShopNow()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//a[text()='Shop now'])[1]")));
	}
	@And ("Click Products under Hair Products section")
	public void clickProducts()
	{
		driver.findElement(By.xpath("(//p[text()='Hair Products'])[1]")).click();
	}
	@And ("Click Hair Beauty Bath")
	public void clickHairBeautyBath()
	{
		driver.findElement(By.xpath("//p[text()='Hair Beauty Bath']")).click();
	}
	@When ("Click Add to cart")
	public void clickAddToCart()
	{
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
	}
	@And ("Navigate to Cart and checkout the product")
	public void checkOut()
	{
		driver.findElement(By.xpath("//div[@class='cart-animation']")).click();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
	}
	@Given ("Click the Shipping Method dropdown and select Worldwide - $5.00 USD")
	public void dropDown()
	{
		WebElement dropDown = driver.findElement(By.xpath("(//select[contains(@class,'position-absolute top-0 right-0')])[3]"));
		Select sc=new Select(dropDown);
		sc.selectByValue("ship_8XxzoB4AglPQAZ");
	}
	@When ("Click Make payment")
	public void makePayment()
	{
		driver.findElement(By.xpath("//button[text()='Make payment']")).click();
	}
	@Then ("Read the order number and print it in console")
	public void readOrderNumber()
	{
		String orderNum = driver.findElement(By.xpath("//p[@class='text-center font-color-light mb-5']")).getText();
		System.out.println(orderNum);
		System.out.println("success 1");
		System.out.println("merge conflict demo from remote");
	}
	}

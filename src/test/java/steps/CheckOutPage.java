package steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;
import io.cucumber.java.en.When;

public class CheckOutPage extends BaseClass{
	@When("Select the Shipping Method as select Worldwide dollar USD")
	public CheckOutPage select_the_shipping_method_as_select_worldwide_dollar_USD() throws IOException{
		WebElement selectelement = driver.findElement(By.xpath("//p[text()='Shipping method*']/following::select"));
		Select slt = new Select(selectelement);
		try {
			slt.selectByVisibleText("Worldwide - $5.00 USD");
			reportStep("The dollar dropdown is selected", "Pass");
		} catch (Exception e) {
			reportStep("The dollar dropdown is not selected"+e, "Fail");
		}
		return this;
	}
	@When("Click Make payment")
	public OrderScreenPage click_make_payment() throws IOException {
		try {
			driver.findElement(By.xpath("//button[text()='Make payment']")).click();
			reportStep("Make Payment is clicked", "Pass");
		} catch (StaleElementReferenceException e) {
			reportStep("Make Payment is not at all clicked", "Fail");
		}
		catch(Exception e)
			{
				reportStep("Make Payment is not at all clicked", "Fail");
			}
		return new OrderScreenPage();
	}	    
}

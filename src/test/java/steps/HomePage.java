package steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass{
	@When("Click the Shop now button")
	
	public CollectionsPage click_the_shop_now_button() throws IOException {
		WebElement shopnow;
		try {
			shopnow = driver.findElement(By.xpath("//a[text()='Shop now']"));
			driver.executeScript("arguments[0].click();", shopnow);
			reportStep("The shop now is clicked", "Pass");
		} catch (Exception e) {
			reportStep("The shop now is not clicked"+e,"Fail");

		}
		return new CollectionsPage();		
	}
	}




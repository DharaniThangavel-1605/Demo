package steps;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.When;

public class CollectionsPage extends BaseClass {
	
	@When("Click Products under Hair Products section.")
	public CollectionsPage click_products_under_hair_products_section() throws IOException {
		try {
			driver.findElement(By.xpath("//p[text()='Hair Products']/following-sibling::a")).click();
			reportStep("Products under Hair Products is clicked","Pass");
		} catch (Exception e) {
			reportStep("Products under Hair Products is not clicked"+e, "Fail");
		}
		return this;
	}
	@When("Click Hair Beauty Bath product")
	public ProdDetailsPage click_hair_beauty_bath_product() throws IOException {
		try {
			driver.findElement(By.xpath("//p[text()='Hair Beauty Bath']")).click();
			reportStep("hair beauty bath product is clicked", "Pass");
		} catch (Exception e) {
			reportStep("hair beauty bath product is not clicked"+e, "Fail");

		}
		return new ProdDetailsPage();
}
}

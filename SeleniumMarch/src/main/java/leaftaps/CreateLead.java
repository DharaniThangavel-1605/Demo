package leaftaps;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CreateLead {
	@Test
	public void createLead()
	{
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.partialLinkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Accounts")).click();
	driver.findElement(By.linkText("Create Account")).click();
	driver.findElement(By.id("accountName")).sendKeys("DharaniThangavel2");
	driver.findElement(By.id("groupNameLocal")).sendKeys("Dh");
	driver.findElement(By.className("smallSubmit")).click();
	String text = driver.findElement(By.xpath("(//td/span[@class='tabletext'])[3]")).getText();
	System.out.println(text);
	if(text.contains("Dharani"))
	{
		System.out.println("Account created successfully");
	}
	else
	{
		System.out.println("Account not created");
	}
	}

}

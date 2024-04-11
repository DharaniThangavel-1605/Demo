package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests {
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public String testName,testDescription;
	public static ExtentTest test;
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}	
	@BeforeClass
	public void startTestCase() {
		test = extent.createTest(testName, testDescription);	
	}	
		public int takeSnap() throws IOException {
        int ranNum = (int) (Math.random() * 999999 + 999999);
        File src = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snaps/img"+ranNum+".png");
        FileUtils.copyFile(src, dest);
        return ranNum;
    }		
    public void reportStep(String msg,String status) throws IOException {
        if (status.equalsIgnoreCase("pass")) {
        	test.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
        }
        else if (status.equalsIgnoreCase("fail")) {
            test.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
        }
    }	

	
	/*
	 * @BeforeMethod public void preCondition() { driver = new ChromeDriver();
	 * driver.get("https://commercejs-demo-store.netlify.app/");
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10)); }
	 */
	  
	  //@AfterMethod public void postCondition(){ driver.close(); }
	 
    @AfterSuite
    public void stopReport() {
        extent.flush();
    }
}

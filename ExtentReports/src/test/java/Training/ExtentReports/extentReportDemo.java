package Training.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReportDemo
{
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		//ExtentReports and ExtentSparkReporter
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Ame Test Result");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ame");
	}
@Test
public void getWebsite()
{
	extent.createTest("Get Website");
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	
	extent.flush();
}
@Test
public void hello()
{
	System.out.println("Hello i changed something");
}
@Test
public void hello1()
{
	System.out.println("Hello i changed something");
	System.out.println("Hello i changed something");
	System.out.println("Hello i changed something");
}

}
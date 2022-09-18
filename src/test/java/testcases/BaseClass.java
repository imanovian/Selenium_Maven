package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	WebDriver driver;
	XSSFWorkbook wbook;
    XSSFSheet sheet;
    ExtentReports report;
    ExtentTest test;
    
    @BeforeTest
    public void DataSetup() throws IOException {
        FileInputStream fis = new FileInputStream("exceldata.xlsx");
        
        wbook = new XSSFWorkbook(fis);
        sheet = wbook.getSheet("Sheet1");
        
        
        
        report = new ExtentReports("ExtentReport.html");
    }
    @AfterTest
    public void DataClean() throws IOException {
    	report.flush();
    	report.close();
    
    	//wbook.close();
    }
	@BeforeMethod 
	public void Setup(Method method) {
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9000,TimeUnit.MILLISECONDS);
	}
	@AfterMethod 
	public void TearDown() {
		report.endTest(test);
		driver.close();
	}
}

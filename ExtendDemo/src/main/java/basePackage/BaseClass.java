package basePackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.extentManager.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
           public static WebDriver driver;
	       
	        
	       @BeforeSuite
	       public void beforesuite() {
	    	   ExtentManager.setExtent();
	       }
	       
	       @AfterSuite
	       public void aftersuite() {
	    	   ExtentManager.endReport();
	       }
	       
	       
	       @BeforeMethod
	       public void setup() {
	    	   WebDriverManager.chromedriver().setup();
	    	   driver = new ChromeDriver();
	    	   driver.manage().window().maximize();
	    	   driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	    	   
	       }
	       @AfterMethod
            public void teardown(ITestResult result) {
	    	   driver.close();
	       }
	       public static String screenShot(WebDriver driver,String filename) {
	    	   String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    	   TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    	   File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    	   String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+"_"+dateName+".png";
	    	   File finalDestination= new File(destination);
	    	   try {
	    	    FileUtils.copyFile(source, finalDestination);
	    	   } catch (Exception e) {
	    	    // TODO Auto-generated catch block
	    	    e.getMessage();
	    	   }
	    	   String newImageString = "http://localhost:8080/job/Demo4/ws/ExtendDemo/ScreenShot/"+filename+"_"
	    			   +dateName+ ".png";
	    	   return destination;
	    	  }
	    	  
	    	  public static String getCurrentTime() {  
	    	      String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());  
	    	      return currentDate;  
	    	  }  
	    	 }


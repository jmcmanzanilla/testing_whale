package WebTesting;

//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ApplicationTest {
	WebDriver driver; 
	  String baseUrl, nodeUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeTest 
		public void setUp() throws MalformedURLException {
			nodeUrl = "http://selenium-hub:4444/wd/hub";
			baseUrl = "http://52.53.188.36/SampleWebApp/";
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			driver = new RemoteWebDriver(new URL(nodeUrl), capability);	
		}	
	  
	  @Test
	  public void testVerifyTitle() throws Exception {
	    driver.get(baseUrl);
		assertEquals(driver.getTitle(), "Global Clock");
	  }
	  
	  @Test
	  public void testVerifyName() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.id("switzerland")).click();
	    assertEquals(driver.findElement(By.id("country")).getText(), "SWITZERLAND");
	  }
	  
	  @Test
	  public void testVerifyTimeDiff() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.id("turkey")).click();
		driver.findElement(By.id("turkeyid")).click();
		assertEquals(driver.findElement(By.id("Turkeybtn")).getText(), "The time difference between Turkey and Philippines is -9 hours");
	  }
  
  @AfterTest 
	public void afterTest() { 
	driver.quit(); 
	} 
}

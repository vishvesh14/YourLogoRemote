package testcases;

import org.testng.annotations.BeforeTest;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Base {
	
	public WebDriver driver;
	public WebDriverWait wait;
	String base_url = "http://automationpractice.com/index.php";
	
	String excel_path = "G:/Workplace/YourLogo/src/utilities/ExcelRead.xlsx";
	String sheetName = "Sheet1";
	
	XSSFWorkbook ExcelWBook;
	XSSFSheet ExcelWSheet;
	XSSFCell Cell;
	
  @BeforeTest
  public void beforeTest() {
	  String base_url = "http://automationpractice.com/index.php";
	  
	  ProfilesIni pro = new ProfilesIni();
	  FirefoxProfile ffProfile = pro.getProfile("vishvesh");
	  ffProfile.setAcceptUntrustedCertificates(true);
	  ffProfile.setAssumeUntrustedCertificateIssuer(false);
	  System.setProperty("webdriver.gecko.driver", "G:/Workplace/AutomationSetupFiles/Geckdriver/geckodriver1.exe");
	  driver = new FirefoxDriver(ffProfile);
	  driver.get(base_url);
	  
//	  System.setProperty("webdriver.chrome.driver","G://Workplace//AutomationSetupFiles//ChromeDriverSelenium//chromedriver");
//	  driver = new ChromeDriver();

  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}

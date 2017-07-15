package testcases;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.Registration;

public class Registatration_Unsuccessful_testcase extends Base{

	@Test
	public void Registration_Unsuccessful() {
		Registration regobj = new Registration(driver);
		String expected ="Invalid email address";
		
		try {
			regobj.ClickSignIn();
			regobj.ClickEmail();

			FileInputStream ExcelFile = new FileInputStream(excel_path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			int row_count = ExcelWSheet.getLastRowNum();
			
			for(int i=1;i<=row_count;i++){
				Cell = ExcelWSheet.getRow(i).getCell(0);
				String celldata = Cell.getStringCellValue();
				regobj.EnterEmail(celldata);
				regobj.ClickCreateAccountButton();
				Thread.sleep(5000);
				
				boolean create_account_error_div = driver.findElement(By.id("create_account_error")).isDisplayed();
				System.out.println(create_account_error_div);
				String actual = driver.findElement(By.id("create_account_error")).getText();
				while(create_account_error_div == true){
					if(expected.equals(actual)){
						System.out.println("Expected: "+actual);
						System.out.println("Actual: "+actual);
						String value="Pass";
						System.out.println(value);
						break;
					}
					else{
						System.out.println("Expected: "+actual);
						System.out.println("Actual: "+actual);
						String value="fail";
						System.out.println(value);
						break;
					}
				}		
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
package testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.Registration;

public class Registatration_Unsuccessful_testcase extends Base{

	@Test
	public void Registration_Unsuccessful() {
		//Object Created for Class Registration
		Registration regobj = new Registration(driver);
		
		//Expected Error Message
		String expected ="Invalid email address.";
		
		try {
			//Calling Methods from Registration Class
			regobj.ClickSignIn();
			regobj.ClickEmail();

			FileInputStream ExcelFile = new FileInputStream(excel_path);
			//FileOutputStream ExcelFileOut = new FileOutputStream(excel_path);
			
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			//Getting the Excel File Row count
			int row_count = ExcelWSheet.getLastRowNum();
			
			//Looping through the row
			for(int i=1;i<=row_count;i++){
				Cell = ExcelWSheet.getRow(i).getCell(0);			//Getting data from Rows
				String celldata = Cell.getStringCellValue();
				regobj.EnterEmail(celldata);
				regobj.ClickCreateAccountButton();					//Calling method from Registration	
				Thread.sleep(5000);
				
				//Checking the Div that has the error message
				boolean create_account_error_div = driver.findElement(By.id("create_account_error")).isDisplayed();
				System.out.println(create_account_error_div);
				String actual = driver.findElement(By.id("create_account_error")).getText();		//Getting Actual Error Message
				int m=1;
				while(create_account_error_div == true){
					if(expected.equals(actual)){
						System.out.println("Expected: "+actual);
						System.out.println("Actual: "+actual);
						String value="Pass";
						//Writing Result in excel file
						ExcelWSheet.getRow(i).createCell(m).setCellValue(value);
						FileOutputStream ExcelFileOut = new FileOutputStream(excel_path);
						ExcelWBook.write(ExcelFileOut);
						break;
					}
					else{
						System.out.println("Expected: "+actual);
						System.out.println("Actual: "+actual);
						String value="fail";
						ExcelWSheet.getRow(i).createCell(m).setCellValue(value);
						FileOutputStream ExcelFileOut = new FileOutputStream(excel_path);
						ExcelWBook.write(ExcelFileOut);
						break;
					}
				}		
			}
			ExcelWBook.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
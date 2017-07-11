package testcases;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import pages.Registration;

public class Registatration_Unsuccessful_testcase extends Base{

	@Test
	public void Registration_Unsuccessful() {
		Registration regobj = new Registration(driver);
		
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
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
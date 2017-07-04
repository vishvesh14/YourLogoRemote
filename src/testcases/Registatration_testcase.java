package testcases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import pages.Registration;

public class Registatration_testcase extends Base{
 
  @Test
  public void Registration() {
	  try {
	  Registration regobj = new Registration(driver);
	  regobj.ClickSignIn();
	  regobj.ClickEmail();
	  FileInputStream ExcelFile = new FileInputStream(excel_path);
	  ExcelWBook = new XSSFWorkbook(ExcelFile);
	  ExcelWSheet = ExcelWBook.getSheet(sheetName);
	  Cell = ExcelWSheet.getRow(0).getCell(0);
	  String celldata = Cell.getStringCellValue();
	  System.out.println("data: "+celldata);
	  regobj.EnterEmail(celldata);
	  }
	  catch(Exception e){
		  System.out.println(e);
	  }
	  
  }
}

package testcases;

import org.testng.annotations.Test;

import pages.Registration;
import utilities.ExcelReadWrite;

public class Registatration_Unsuccessful_testcase extends Base{
 
  @Test
  public void Registration() {
	  try {
	  Registration regobj = new Registration(driver);
	  ExcelReadWrite regex = new ExcelReadWrite(regobj);
	  
	  regobj.ClickSignIn();
	  regobj.ClickEmail();
	  regex.Read_Write_Excel();
	  regobj.ClickCreateAccountButton();
	  }
	  catch(Exception e){
		  System.out.println(e);
	  }
	  
  }
}

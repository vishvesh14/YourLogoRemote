package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testcases.Base;

public class Registration extends Base{
	
	@FindBy(xpath="//*[@id='header']/div[2]//div[1]/a")
	WebElement SignIn;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement Registration_Email;
	
	@FindBy(id="SubmitCreate")
	WebElement Create_Account_Button;
	
	public Registration(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickSignIn(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(SignIn)).click();
	}
	
	public void ClickEmail(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Registration_Email)).click();
	}
	
	public void EnterEmail(String x){
		Registration_Email.sendKeys(x);
	}
	
	public void ClickCreateAccountButton(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Create_Account_Button)).click();
	}
}

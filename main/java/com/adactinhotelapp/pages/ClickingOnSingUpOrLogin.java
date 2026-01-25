package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.adactinhotelapp.utils.ElementUtils;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class ClickingOnSingUpOrLogin extends BasePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signUpOrLogin;

	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement newUserSignUp;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement enterName;

	@FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
	private WebElement enterEmail;

	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement submit;

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement accountInformation;

	@FindBy(xpath = "//label[@for='id_gender1']")
	private WebElement gender1;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement defaultName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement defaultEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement enterPassword;
	
	@FindBy(xpath="//select[@id='days']")
	private WebElement selectDate;
	
	@FindBy(xpath="//select[@id='months']")
	private WebElement selectMonth;
	
	@FindBy(xpath="//select[@id='years']")
	private WebElement selectYear;
	
	@FindBy(xpath="//input[@id='newsletter']")
	private WebElement checkNewsLetter;
	
	@FindBy(xpath="//input[@id='optin']")
	private WebElement checkOptin;

	public ClickingOnSingUpOrLogin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		elementUtils = new ElementUtils(driver);

	}

	public void signUpOrLogin() {
		signUpOrLogin.click();
		ChainTestListener.log("Clicking on the signUp or Login button");
	}

	public String isNewUserSingUpDisplayed() {
		return newUserSignUp.getText();

	}

	public void enterUsername(String userName) {
		enterName.sendKeys(userName);
		ChainTestListener.log("Entering the New User Name");
	}

	public void enterUserEmail(String email) {
		enterEmail.sendKeys(email);
		ChainTestListener.log("Entering the New User Email");
	}

	public void clickSubmit() {
		submit.click();
		ChainTestListener.log("Clicking on Submit");
	}

	public String isAccountInformationVisible() {
		return accountInformation.getText();

	}

	public void selectMageGender() {
		gender1.click();
		ChainTestListener.log("Selecting the Gender 1 as Male...");
	}

	public String defaultName(String getDefaultName) {

		ChainTestListener.log("Printing the text that is already existing");
		return defaultName.getAttribute("value").trim();
	}

	public String getDefaultEmail(String getEmail) {

		return defaultEmail.getAttribute("value").trim();

	}

	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	
	public WebElement selectTheDate() {
		return selectDate;
		
	}
	
	public WebElement selectTheMonth() {
		return selectMonth;
		
	}
	
	public WebElement selectTheYear() {
		return selectYear;
		
	}
	
	public void clickingOnNewsLetterCheckBox() {
		checkNewsLetter.click();
	}
	
	public void clickingOnReceiveSpecialOfferCheckBox() {
		checkOptin.click();
	}

}

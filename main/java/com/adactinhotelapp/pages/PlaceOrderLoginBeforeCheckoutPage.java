package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class PlaceOrderLoginBeforeCheckoutPage extends BasePage {

	private ElementUtils elementUtils;

	public PlaceOrderLoginBeforeCheckoutPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	private WebElement signupOrLoginButton;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailInputField;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordInputField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//i[@class='fa fa-user']/following-sibling::b")
	private WebElement loggedInAsUsername;

	@FindBy(xpath = "//div[@class='productinfo text-center']/child::a[text()='Add to cart']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewCartButton;
	
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement proceedToCheckOutButton;

	public void clickSignupOrLoginButton() {
		elementUtils.clickWhenReady(signupOrLoginButton);
	}

	public void EnterLoginDetails(String email, String password) {
		elementUtils.doSendKeys(emailInputField, email);
		elementUtils.doSendKeys(passwordInputField, password);
		loginButton.click();
	}

	public String getLoggedInAsUsername() {
		return loggedInAsUsername.getText();
	}

	public void clickAddToCartButton() {
		elementUtils.scrollUsingActionsClass(addToCartButton);
	}

	public void clickViewCartButton() {
		elementUtils.clickWhenReady(viewCartButton);
	}
	
	public void clickProceedToCheckOutButton() {
		elementUtils.clickWhenReady(proceedToCheckOutButton);
	}
	
	

}

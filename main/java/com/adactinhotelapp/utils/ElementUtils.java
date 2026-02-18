package com.adactinhotelapp.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriver driver;
	private final int DEFAULT_TIMEOUT = 10;
	private WebDriverWait wait;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

	public WebElement getElement(By by) {

		WebElement element = null;

		element = driver.findElement(by);

		if (isElementDisplayed(element)) {
			return element;
		} else {
			return element;
		}

	}

	/**
	 * Waits for an element to be visible and then clicks it.
	 */
	public void clickWhenReady(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	/**
	 * Generic sendKeys with visibility check.
	 */
	public void doSendKeys(WebElement element, String value) {
		waitForElementVisible(element, DEFAULT_TIMEOUT);
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Waits for an element to be visible before returning it.
	 */

	public WebElement waitsForElementVisible(WebElement element, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Wait for an element to be visible on the DOM.
	 */
	public WebElement waitForElementVisible(WebElement element, int timeout) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Overloaded method to wait for an element using a By locator (useful for
	 * dynamic elements).
	 */
	public WebElement waitForElementVisible(By locator, int timeout) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Capture text from an element after ensuring it is visible.
	 */
	public String doGetElementText(WebElement element) {
		return waitForElementVisible(element, DEFAULT_TIMEOUT).getText();
	}

	/**
	 * Check if an element is displayed without throwing an immediate exception.
	 */
	public boolean isElementDisplayed(WebElement element) {
		try {
			return waitForElementVisible(element, 5).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Waits for a frame to be visible and switch into it.
	 */
	public void clickingAlertClosing(WebElement frameName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));

	}

	/**
	 * Scrolling to the bottom of the page using JavaScriptExecutor.
	 */
	public void scrollToTheBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
}

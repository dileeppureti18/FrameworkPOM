package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.ClickingOnSingUpOrLogin;
import com.adactinhotelapp.utils.ExcelUtils;

public class SignUpOrLogIn extends BaseTest {

	@Test(dataProvider = "getData")
	public void loginOrSignUp(HashMap<String, String> dataMap) {

		ClickingOnSingUpOrLogin page = new ClickingOnSingUpOrLogin(driver);
		Assert.assertEquals(page.getTitle(), AppConstants.E_Commerce_Home_Page);

		page.signUpOrLogin();
		Assert.assertEquals(page.getTitle(), AppConstants.LOGIN_PAGE_TITLE);

		Assert.assertEquals(page.isNewUserSingUpDisplayed(), "New User Signup!");

		page.enterUsername(dataMap.get("Name"));

		page.enterUserEmail(dataMap.get("Email Address"));

		page.clickSubmit();

		Assert.assertEquals(page.isAccountInformationVisible(), "ENTER ACCOUNT INFORMATION");

		Assert.assertEquals(page.getTitle(), AppConstants.SIGN_UP_PAGE);

		page.selectMageGender();

		Assert.assertEquals(page.defaultName(dataMap.get("Name")), dataMap.get("Name"));

		Assert.assertEquals(page.getDefaultEmail(dataMap.get("Email Address")), dataMap.get("Email Address"));

		page.enterPassword(dataMap.get("Password"));

		new Select(page.selectTheDate()).selectByValue("18");
		new Select(page.selectTheMonth()).selectByVisibleText("November");
		new Select(page.selectTheYear()).selectByValue("1997");

		page.clickingOnNewsLetterCheckBox();
		page.clickingOnReceiveSpecialOfferCheckBox();

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC104");
		data[0][0] = testData;
		return data;

	}

}

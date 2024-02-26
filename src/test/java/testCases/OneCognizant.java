package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OneCogniPage;
import testBase.BaseTest;

public class OneCognizant extends BaseTest {

	public OneCogniPage oneCogniPage;

	@Test(priority = 1)
	public void searchTruTime() throws InterruptedException {
		oneCogniPage = new OneCogniPage(driver);

		oneCogniPage.switchToOneCogniHandle();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		oneCogniPage.clickOnSearch();
		oneCogniPage.searchTruTime("TruTime");
	}

	@Test(priority = 2, dependsOnMethods = { "searchTruTime" })
	public void validateTruTimePage() {

		Assert.assertEquals(oneCogniPage.verifyTruTimePage(), true, "TruTime page NOT found");
	}

}

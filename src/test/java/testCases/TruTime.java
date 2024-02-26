package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.TruTimePageObj;
import testBase.BaseTest;
import utilities.CalenderDDMMYYY;

public class TruTime extends BaseTest {

	TruTimePageObj ttpo;
	CalenderDDMMYYY my = new CalenderDDMMYYY();

	@Test(priority = 1)
	public void validateCurrentMonthAndYear() {
		ttpo = new TruTimePageObj(driver);
		SoftAssert as1 = new SoftAssert();
		as1.assertEquals(ttpo.getMonth(), my.localCurrentMonth());
		as1.assertEquals(ttpo.getYear(), my.localCurrentYear());
		as1.assertAll();
	}

	@Test(priority = 2)
	public void validateBackDatedTopUp() {
		Assert.assertEquals(ttpo.backDatedTopUp(), my.date15DaysBefore());
	}

	@Test(priority = 3)
	public void printLegends() {
		Assert.assertEquals(ttpo.getLegends(), 15);
	}

	@Test(priority = 4)
	public void validateCurrentHighlightedDate() {
		Assert.assertEquals(ttpo.getCurrentHighlightedDay(), my.localHighlightedDayDateFormat());
	}

	@Test(priority = 5)
	public void validateTruTimeDates() {

		Assert.assertEquals(ttpo.getCurrentWeekDatesInTruTime(), true);
	}
}

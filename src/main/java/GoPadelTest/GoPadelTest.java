package GoPadelTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import GoPadelPages.GoPadelCalendarPage;
import GoPadelPages.GoPadelDashboardPage;
import GoPadelPages.GoPadelLoginPage;
import TestScenario.GoPadelTestBase;

public class GoPadelTest extends GoPadelTestBase {

	GoPadelLoginPage loginPage;
	GoPadelCalendarPage calendarPage;

	// Log4j configuration
	private static final Logger log = LogManager.getLogger(GoPadelTest.class);

	@Test
	public void bookingCalenderTest() {

		log.info("Verifying successful login.");

		loginPage = new GoPadelLoginPage(driver);

		// Should fetch the username and password from external test data files
		GoPadelDashboardPage dashboardPage = loginPage.login("admin", "Admin@12345");
		dashboardPage.navigateToCalendar();
		dashboardPage.displaydetails();
		dashboardPage.clickOnCalendar();
		String ExpectedUrl = "https://gopadel.cadvil.com/admin/padel-calenderV2";
		String Actualurl = dashboardPage.getUrl();

		log.info("Calendar page is displayed.");
		log.info("expectedUrl-" + ExpectedUrl + " and actualUrl - " + Actualurl);
		Assert.assertEquals(ExpectedUrl, Actualurl);

	}

	@Test
	public void verifyDetails() {

		calendarPage = new GoPadelCalendarPage(driver);
		String ExpectedTitle = "Calendar";
		String ActualTitle = calendarPage.calendarPageDetails();
		log.info("expectedTitle-" + ExpectedTitle + " and actualTitle - " + ActualTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle);

		calendarPage.padelName();
		calendarPage.branchName();
		calendarPage.rightClickOnTimeSlots();
		calendarPage.arrowButtons();
		calendarPage.bookingWindow();

	}

	@Test
	public void bookingWindowDetails() {

		calendarPage = new GoPadelCalendarPage(driver);

		calendarPage.bookingWindow();

	}

}

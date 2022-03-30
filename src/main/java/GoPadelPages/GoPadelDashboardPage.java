package GoPadelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GoPadelDashboardPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul[1]/li/a")
	WebElement menu;

	@FindBy(xpath = "//*[@id=\"sidebarnav\"]/li[2]/a")
	WebElement booking;

	@FindBy(xpath = "//*[@id=\"sidebarnav\"]/li[2]/ul/li[1]/a/span")
	WebElement bookinglist;

	@FindBy(xpath = "//*[@id=\"sidebarnav\"]/li[2]/ul/li[3]/a/span")
	WebElement createbooking;

	@FindBy(xpath = "//*[@id=\"sidebarnav\"]/li[2]/ul/li[2]/a/span")
	WebElement calendar;

	public GoPadelDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToCalendar() {
		menu.click();
		booking.click();
	}

	public void displaydetails() {
		Assert.assertEquals(true, bookinglist.isDisplayed());
		Assert.assertEquals(true, createbooking.isDisplayed());
		Assert.assertEquals(true, calendar.isDisplayed());
	}

	public void clickOnCalendar() {
		calendar.click();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

}

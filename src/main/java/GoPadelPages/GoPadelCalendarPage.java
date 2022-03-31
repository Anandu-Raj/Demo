package GoPadelPages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GoPadelCalendarPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/div[1]/h3")
	WebElement calendar;

	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/div[2]/ol")
	WebElement breadcrumb;

	@FindBy(xpath = "(//*[@id=\"ddlPadelId\"])[1]")
	WebElement padelname;

	@FindBy(xpath = "//*[@id=\"ddlPadelBranch\"]")
	WebElement branchname;

	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement gobutton;

	@FindBy(xpath = "//*[@id=\"schedule\"]/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td[1]")
	WebElement timeslot;

	@FindBy(xpath = "//*[text()=\"Add New Booking\"]")
	WebElement addnewbooking;

	@FindBy(xpath = "//*[text()='Block Slots']")
	WebElement blockslots;

	@FindBy(xpath = "//*[text()='Mark as Ladies Time']")
	WebElement markasLadiestime;

	@FindBy(xpath = "//*[@id=\"e-tbr-btn_1\"]")
	WebElement leftarrow;

	@FindBy(xpath = "//*[@id=\"e-tbr-btn_2\"]")
	WebElement rightarrow;

	@FindBy(xpath = "//*[@id=\"e-tbr-btn_3\"]")
	WebElement date;

	@FindBy(xpath = "//*[@id=\"NewBookingModalLabel\"]")
	WebElement title;

	@FindBy(xpath = "//*[@id=\"startTime\"]")
	WebElement startTime;

	@FindBy(xpath = "//*[@id=\"endTime\"]")
	WebElement endTime;

	@FindBy(id = "ddlTrainerId")
	WebElement trainer;
	
	@FindBy(xpath = "//*[text()='Client Information']")
	WebElement clientinformation;

	@FindBy(xpath = "//*[@id=\"MemberId_0\"]")
	WebElement clientname;
	
	
	public GoPadelCalendarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String calendarPageDetails() {
		Assert.assertEquals(true, breadcrumb.isDisplayed());
		Assert.assertEquals(true, padelname.isDisplayed());
		Assert.assertEquals(true, branchname.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Breadcrumb is displayed");
		System.out.println(" > Padel Name is displayed");
		System.out.println(" > Branch Name is displayed");
		return calendar.getText();
	}

	public void padelName() {

		Select padleselect = new Select(padelname);
		System.out.println("------------------------------------------------");

		List<WebElement> padledropdown = padleselect.getOptions();
		for (WebElement padelname : padledropdown) {
			System.out.println(" > " + padelname.getText());
		}
		padelname.click();
		padleselect.selectByIndex(1);

	}

	public void branchName() {

		Select branchselect = new Select(branchname);
		branchselect.selectByIndex(1);
		System.out.println("------------------------------------------------");

		List<WebElement> branchdropdown = branchselect.getOptions();
		for (WebElement branchname : branchdropdown) {
			System.out.println(" > " + branchname.getText());
		}

		Assert.assertEquals(true, gobutton.isDisplayed());
		gobutton.click();
	}

	public void arrowButtons() {
		leftarrow.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > " + date.getText());
		rightarrow.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > " + date.getText());
	}

	public void bookingWindow() {
		timeslot.click();
		Actions action = new Actions(driver);
		action.contextClick(timeslot).perform();

		Assert.assertEquals(true, addnewbooking.isDisplayed());
		Assert.assertEquals(true, blockslots.isDisplayed());
		Assert.assertEquals(true, markasLadiestime.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Add New Booking is displayed");
		System.out.println(" > Block slots is displayed");
		System.out.println(" > Mark Ladies Time is displayed");
		addnewbooking.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > " + title.getText());
		System.out.println("------------------------------------------------");
		System.out.println(" > " + startTime.getText());
		System.out.println("------------------------------------------------");
		System.out.println(" > " + endTime.getText());
		startTime.clear();
		startTime.sendKeys("10:00");
		System.out.println("------------------------------------------------");
		System.out.println(" > Edited Time : " + startTime.getText());
		endTime.clear();
		endTime.sendKeys("12:00");
		System.out.println("------------------------------------------------");
		System.out.println(" > Edited Time : " + endTime.getText());

		Select Trainer = new Select(trainer);
		Trainer.selectByIndex(1);
		System.out.println("------------------------------------------------");

		List<WebElement> Trainerdropdown = Trainer.getOptions();
		for (WebElement trainer : Trainerdropdown) {
			System.out.println(" > " + trainer.getText());
		}
		
		System.out.println("------------------------------------------------");
		System.out.println(" > " + clientinformation.getText());
		
		Select ClinetName = new Select(clientinformation);
		ClinetName.selectByIndex(1);
		System.out.println("------------------------------------------------");

		List<WebElement> Clientdropdown = ClinetName.getOptions();
		for (WebElement client : Clientdropdown) {
			System.out.println(" > " + client.getText());
		}

	}

}

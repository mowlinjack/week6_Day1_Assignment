package StepDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.asserts.Assertion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefFile {
	
public ChromeDriver driver;
public List<String> allhandles;
public List<String> allhandles2;
public String leadID;
	
@Given("Launch chrome browser")
public void launch_chrome_browser() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
    driver.manage().window().maximize();

   
}
@Given("Launch URL {string}")
public void launch_url(String url) {

	 driver.get(url);
}

@Given("Enter usernam and Password {string} {string}")
public void enter_usernam_and_password(String uname , String pwd) {

	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys(uname);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys(pwd);
	
    
}
@When("Click on signon")
public void click_on_signon() {
	WebElement loginbutton = driver.findElement(By.className("decorativeSubmit"));
	loginbutton.click();

}
@Then("Home page should be displayed")
public void home_page_should_be_displayed() {

WebElement findElement = driver.findElement(By.linkText("CRM/SFA"));
	Assert.assertEquals(true, findElement.isDisplayed());

}


@Then("Click on CRM\\/SFA link")
public void click_on_crm_sfa_link() {
	driver.findElement(By.linkText("CRM/SFA")).click(); 
    
}


@Then("Click on Leads")
public void click_on_leads() {
	driver.findElement(By.linkText("Leads")).click();
}

//Create Lead


@And("Click Create lead")
public void createlead() {
	driver.findElement(By.linkText("Create Lead")).click();
}

@Then("Click on Find leades in leads")
public void click_on_find_leades_in_leads() {
	driver.findElement(By.linkText("Find Leads")).click();
}


@Then("Enter {string} {string} {string} {string} input values for create a lead")
public void enter_input_values_for_create_a_lead(String string, String string2, String string3, String string4) {
	
	
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(string);
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(string2);
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(string3);
	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(string4);
    
}


@When("click on submit button")
public void click_on_submit_button() {
	
	driver.findElement(By.name("submitButton")).click();	
    
}


@Then("verify lead should be created successfully")
public void verify_lead_should_be_created_successfully() {
} 

@When("Click on phone text field and enter {string}")
public void click_on_phone_text_field_and_enter(String string) {
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(string);
}

@When("Click on find leads")
public void click_on_find_leads() throws Exception {
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
}

@When("Click on first item in the list")
public void click_on_first_item_in_the_list() {
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
}

@When("Click on Duplicate lead")
public void click_on_duplicate_lead() {
	driver.findElement(By.linkText("Duplicate Lead")).click();
}


@When("Click on Submit")
public void click_on_submit() {
	driver.findElement(By.name("submitButton")).click();
}


@And("Click on Edit link")
public void click_on_EditLink() {
	//driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Edit")).click();
}


//@And("Click on Edit link")
//public void click_on_EditLink() {
//	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
//	driver.findElement(By.linkText("Edit")).click();
//}

@And("Enter Updated company name {string}")
public void Enter_updated(String str) {
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
}


///  Merge Lead

@Then("Click on Merge Lead")
public void click_on_merge_lead() {
	driver.findElement(By.linkText("Merge Leads")).click();   
    
}
@Then("Click on look up")
public void click_on_look_up() {
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();  
    
}
@Then("Enter FirstNAme {string}")
public void enter_first_n_ame(String string) {
  
	Set<String> allWindows = driver.getWindowHandles();
	 allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(string);
    
}
@Then("I Get lead id")
public void i_get_lead_id() {
    
	 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

}


@Then("clickon lead ID")
public void clickon_lead_id() {
	driver.switchTo().window(allhandles.get(0));    
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1)); 
    
}
@Then("I click merge lead")
public void i_click_merge_lead() {
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();   
    
}
@Then("Enter fetched find lead")
public void enter_fetched_find_lead() {
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);  
    
}
@Then("I click on find leads")
public void i_click_on_find_leads() {
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); 
    
}
@Then("check Merged lead")
public void check_merged_lead() {
    
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}


/// Delete Lead

@When("Get LeadID there")
public void get_lead_id_there() {
	leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
   
}
@When("Click Delete")
public void click_delete() {
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Delete")).click();
   
}
@Then("Check deleted lead display")
public void check_deleted_lead_display() {
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
   
}



@Then("quit")
public void quit() {
	driver.quit();
}





}

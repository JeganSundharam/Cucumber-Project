package org.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.utilies.BaseClass;
import org.utilies.FacebookLoginPagePojo;

import io.cucumber.java.en.*;

public class FacebookStepDefinitionFeature extends BaseClass {
	@Given("launch the browser Chrome")
	public void launch_the_browser_Chrome() {
		
	}

	@When("load the URL and maximize the page")
	public void load_the_URL_and_maximize_the_page() {
		
	}

	@When("locate the Username box and send the Valid values")
	public void locate_the_Username_box_and_send_the_Valid_values() {
		FacebookLoginPagePojo f = new FacebookLoginPagePojo();
		f.getUsernameBox().sendKeys("chen");

	}

	@When("locate the Password box and send the Valid Values")
	public void locate_the_Password_box_and_send_the_Valid_Values() {
		FacebookLoginPagePojo f = new FacebookLoginPagePojo();
		f.getPasswordBox().sendKeys("chenn@123");
	}

	@When("click on the Login button")
	public void click_on_the_Login_button() throws InterruptedException {
		FacebookLoginPagePojo f = new FacebookLoginPagePojo();
		f.getLoginBtn().click();
				Thread.sleep(3000);
	}

	@Then("Invalid Credentials page is visible")
	public void invalid_Credentials_page_is_visible() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("mutation_token"));
	}

	@When("locate the Username box and {string} send the  Valid values")
	public void locate_the_Username_box_and_send_the_Valid_values(String S1) {
		FacebookLoginPagePojo f = new FacebookLoginPagePojo();
		f.getUsernameBox().sendKeys(S1);
	}

	@When("locate the Password box and send the Valid Values{string}")
	public void locate_the_Password_box_and_send_the_Valid_Values(String S) {
		FacebookLoginPagePojo f = new FacebookLoginPagePojo();
		f.getPasswordBox().sendKeys(S);
		
	}

	@When("locate the Username box and send the Valid value")
	public void locate_the_Username_box_and_send_the_Valid_value(io.cucumber.datatable.DataTable dt) {
		String s = dt.asMaps().get(0).get("12345");
		FacebookLoginPagePojo f = new FacebookLoginPagePojo();
		f.getUsernameBox().sendKeys(s);
	}

	@When("locate the Password box and send the Valid Value")
	public void locate_the_Password_box_and_send_the_Valid_Value(io.cucumber.datatable.DataTable dT) {
		String s = dT.asLists().get(0).get(1);
		FacebookLoginPagePojo f = new FacebookLoginPagePojo();
		f.getPasswordBox().sendKeys(s);
	}

}

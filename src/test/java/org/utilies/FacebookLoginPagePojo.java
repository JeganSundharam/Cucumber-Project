package org.utilies;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPagePojo extends BaseClass {
	public FacebookLoginPagePojo() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//input[@name='email']")
private WebElement usernameBox;

@FindBy(xpath="//input[@id='pass']")
private WebElement passwordBox;

@FindBy(xpath="//button[@name='login']")
private WebElement loginBtn;

public WebElement getUsernameBox() {
	return usernameBox;
}

public WebElement getPasswordBox() {
	return passwordBox;
}

public WebElement getLoginBtn() {
	return loginBtn;
}






}

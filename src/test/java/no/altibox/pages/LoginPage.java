package no.altibox.pages;

import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@class='loginButton']")
    public WebElement loginButton;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "(//*[@class='button'])[1]")
    public WebElement submit;

    @FindBy(xpath = "//*[@class='user-menu-container']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOut;

    public void login(String userNameStr,String passwordStr)  {
        loginButton.click();
        BrowserUtils.waitFor(2);
        userNameBox.sendKeys(userNameStr);
        passwordBox.sendKeys(passwordStr);
        submit.click();

    }


    public void Logout() {
        logoutButton.click();
        signOut.click();

    }

    public void loginOnLoginPage(String userNameStr,String passwordStr) {
        BrowserUtils.waitFor(2);
        userNameBox.sendKeys(userNameStr);
        passwordBox.sendKeys(passwordStr);
        submit.click();
    }


}

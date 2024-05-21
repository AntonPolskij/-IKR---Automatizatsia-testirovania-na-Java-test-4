package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css="input[type='email']")
    private WebElement loginField;

    @FindBy(xpath="//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "parsley-id-5")
    private WebElement loginInputInfo;

    @FindBy(id = "parsley-id-7")
    private WebElement passwordInputInfo;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeLoginInField(String username) {
        loginField.sendKeys(username);
    }
    public void typePasswordInField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        submitButton.click();
    }

    public void login(String  username,String  password) {
        typeLoginInField(username);
        typePasswordInField(password);
        clickLoginButton();
    }

    public String getLoginInputInfo() {
        return loginInputInfo.getText();
    }

    public String getPasswordInputInfo() {
        return passwordInputInfo.getText();
    }
}

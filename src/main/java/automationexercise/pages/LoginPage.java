package automationexercise.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver ;
    private String pageURL = "https://automationexercise.com";

    //Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver ;
    }

    public LoginPage urlNavigate(){
        driver.browser().navigateToURL(pageURL);
        return this;
    }

    //Locators
    private By loginTabButton = By.xpath("//a[@href='/login']");
    private By loginHeaderCL = By.xpath("//div[@class='login-form']//h2");
    private By emailTextBox = By.xpath("//input[@data-qa='login-email']");
    private By passwordTextBox = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By logoutButton = By.xpath("//a[@href='/logout']");

    //Validations
    @Step("Validate that the logout button is displayed when logging in")
    public void validateLogin (String logoutText){
        driver.verifyThat().element(logoutButton).text().isEqualTo(logoutText).perform();
    }

    //Actions
    public LoginPage ClickOnLoginTabButton(){
        driver.element().click(loginTabButton);
        return this;
    }

    public LoginPage FillLoginData (String userName , String password){
        driver.element().type(emailTextBox,userName);
        driver.element().type(passwordTextBox,password);
        return this ;
    }

    public LoginPage ClickOnLoginButton(){
        driver.element().click(loginButton);
        return this;
    }
}

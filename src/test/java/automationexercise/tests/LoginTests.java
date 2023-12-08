package automationexercise.tests;


import automationexercise.pages.LoginPage;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Epic("UserManagement")
@Story("Login")
public class LoginTests {
    private SHAFT.GUI.WebDriver driver;
    private JSONFileManager testData;

    @Test(description = "Validating that the user can login successfully")
    private void ValidateLogin(){
        new LoginPage(driver).ClickOnLoginTabButton()
                .FillLoginData(testData.getTestData("userName"),testData.getTestData("passWord"))
                .ClickOnLoginButton()
                .validateLogin(testData.getTestData("expectedText"));
    }

    @BeforeClass
    @Description("Setting JSON File")
    public void beforeClass(){
        testData = new JSONFileManager("src/test/resources/automationexercise/Test Data/loginTestData.json");
    }

    @BeforeMethod
    @Description("Navigating to Base URL")
    public void setup(){
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).urlNavigate();
    }

    @AfterMethod
    @Description("Close the browser after test")
    public void tearDown(){
        driver.browser().closeCurrentWindow();
    }

}

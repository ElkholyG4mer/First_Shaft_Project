package automationexercise.tests;


import automationexercise.APIs.RegisterAPI;
import automationexercise.pages.LoginPage;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.json.JSONException;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Epic("UserManagement")
@Story("Login")
public class LoginTests {
    private SHAFT.GUI.WebDriver driver;
    SHAFT.API apidriver ;
    private JSONFileManager testData;

    //Variables
    private String baseURL = "https://automationexercise.com";
    String email = "mostafa" + new SimpleDateFormat("MMddyyyyhhmmssSSSS").format(new Date()) + "@gmail.com";

    @Test(description = "Validating that the user can login successfully")
    private void ValidateLogin() throws JSONException {
        new RegisterAPI(apidriver).createUser(testData.getTestData("userName"),email,testData.getTestData("passWord"));

        new LoginPage(driver).urlNavigate().ClickOnLoginTabButton()
                .FillLoginData(email,testData.getTestData("passWord"))
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
        apidriver = new SHAFT.API(baseURL + "/api/");
    }

    @AfterMethod
    @Description("Close the browser after test")
    public void tearDown(){
        driver.browser().closeCurrentWindow();
    }

}

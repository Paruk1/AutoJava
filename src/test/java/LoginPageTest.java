import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","..\\githubTest\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/session");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void enterInvalidInfo(){
        LoginPage NewLoginPage = loginPage.loginInvalidInfo("parail200111@gmail.com ","terya2010");
        String error = NewLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }
    @Test
    public void enterEmptyField(){
        LoginPage NewLoginPage = loginPage.loginInvalidInfo("","");
        String error = NewLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
        public void createUser(){
        SignUpPage signUpPage = loginPage.createAccount();
        String headingText = signUpPage.getHeadText();
        Assert.assertEquals("Create your account",headingText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

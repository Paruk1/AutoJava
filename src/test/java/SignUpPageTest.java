import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","..\\githubTest\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join?return_to=%2Fenterprise&source=login");
        signUpPage = new SignUpPage(driver);
    }


    @Test
    public void enterInvalidUserName(){
        SignUpPage signUpPage1 = signUpPage.enterUserName("test");
        String error = signUpPage1.getUserNameError();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Username test is not available.",error);
    }
    @Test
    public void enterInvalidPassword(){
        SignUpPage signUpPage1 = signUpPage.enterPassword("test");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String error = signUpPage1.getPasswordError();
        Assert.assertEquals("Password is too short (minimum is 8 characters), needs at least 1 number, and is in a list of passwords commonly used on other websites",error);
    }
    @Test
    public void enterInvalidEmail(){
        SignUpPage signUpPage1 = signUpPage.enterEmail("test");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         String error = signUpPage1.getEmailError();
        Assert.assertEquals("Email is invalid or already taken",error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

import com.sun.tools.javac.Main;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","..\\githubTest\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void clickButtonSignUp(){
        SignUpPage signUpPage = mainPage.signUpClick();
        String headingText = signUpPage.getHeadText();
        Assert.assertEquals("Create your account",headingText);
    }
    @Test
    public void clickButtonSignIn(){
        LoginPage loginPage = mainPage.signInClick();
        String headingText = loginPage.getHeadText();
        Assert.assertEquals("Sign in to GitHub",headingText);
    }
    @Test
    public void clickSignUpForGitHubClick(){
        SignUpPage signUpPage = mainPage.signUpForGitHubClick();
        String headingText = signUpPage.getHeadText();
        Assert.assertEquals("Create your account",headingText);
    }
    @Test
    public void enterToEmailFieldValidInfo(){
        mainPage.enterEmailField("parail200111@gmail.com");
        SignUpPage signUpPage = mainPage.signUpForGitHubClick();
        String headingText = signUpPage.getHeadText();
        Assert.assertEquals("Create your account",headingText);
    }
    @Test
    public void clickScrollSignUp(){
        ((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
        mainPage.scrollSignUpClick();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","..\\githubTest\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join?return_to=%2Fenterprise&source=login");

        SignUpPage signUpPage = new SignUpPage(driver);

        SignUpPage signUpPage1 = signUpPage.enterUserName("test");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String error = signUpPage1.getUserNameError();
        System.out.println(error);
        driver.quit();
        Assert.assertEquals("Username test is not available.",error);
    }
}

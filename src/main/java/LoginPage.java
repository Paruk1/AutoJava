import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//div[contains(@class,'flash flash-full flash-error')]/div[contains(@class,'container-lg')]")
    private WebElement error;
    @FindBy(xpath = "//*[@value='Sign in']")
    private WebElement signIn;
    @FindBy(xpath = "//h1[contains(text(),'Sign in to GitHub')]")
    private WebElement heading;
    @FindBy(xpath = "//a[contains(text(),'Forgot password')]")
    private WebElement forgotPassword;
    @FindBy(xpath = "//a[contains(text(),'Create an account')]")
    private WebElement creatingUser;

    public LoginPage enterUserName(String name){
        username.sendKeys(name);
        return this;
    }
    public LoginPage enterPassword(String passwordText){
        password.sendKeys(passwordText);
        return this;
    }

    public LoginPage loginInvalidInfo(String name,String passwordText) {
        enterUserName(name);
        enterPassword(passwordText);
        signIn.click();
        return new LoginPage(driver);
    }

    public String getHeadText(){
        return heading.getText();
    }

    public String getErrorText(){
        return error.getText();
    }

    public SignUpPage createAccount(){
        creatingUser.click();
        return new SignUpPage(driver);
    }

    public LoginPage creatingUserClick(){
        creatingUser.click();
        return this; //создаем объект новой страницы, в которую передаем driver
    }



}

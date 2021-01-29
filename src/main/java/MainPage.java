import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    } // alt+insert

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signIn;
    @FindBy(xpath = "//a[contains(@class,'HeaderMenu-link d-inline-block')]")
    private WebElement signUp;
    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement scrollSignUp;
    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement emailField;
    @FindBy(xpath = "//h2[text()='Make your contribution']/following-sibling::a[contains(text(),'Sign up for GitHub')]")
    private WebElement signUpForGitHub;


    public LoginPage signInClick(){
        signIn.click();
        return new LoginPage(driver); //создаем объект новой страницы, в которую передаем driver
    }

    public SignUpPage signUpClick(){
        signUp.click();
        return new SignUpPage(driver);
    }
    public SignUpPage scrollSignUpClick(){
        scrollSignUp.click();
        return new SignUpPage(driver);
    }

    public SignUpPage signUpForGitHubClick(){
        signUpForGitHub.click();
        return new SignUpPage(driver);
    }
    public SignUpPage enterEmailField(String emailText){
        emailField.sendKeys(emailText);
        return new SignUpPage(driver);
    }


}

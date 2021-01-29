import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Create your account']")
    private WebElement headText;
    @FindBy(xpath = "//*[@id='user_login']")
    private WebElement username;
    @FindBy(xpath = "//*[@id='user_email']")
    private WebElement email;
    @FindBy(xpath = "//*[@id='user_password']")
    private WebElement password;
    @FindBy(xpath = "//input[@name='user[login]']/parent::dd/following::dd[1]/div")
    private WebElement usernameError;
    @FindBy(xpath = "//input[@name='user[email]']/parent::dd/following::dd[1][@class='error']")
    private WebElement emailError;
    @FindBy(xpath = "//input[@name='user[password]']/parent::dd/following::dd[1][@class='error']")
    private WebElement passwordError;


    public SignUpPage enterUserName(String textName){
        username.sendKeys(textName);
        return this;
    }
    public SignUpPage enterEmail(String textEmail){
        email.sendKeys(textEmail);
        return this;
    }
    public SignUpPage enterPassword(String textPassword){
        password.sendKeys(textPassword);
        return this;
    }
    public SignUpPage enterInvalidData(String name,String email,String password) {
        this.enterUserName(name);
        this.enterEmail(email);
        this.enterPassword(password);
        return this;
    }
    public String getUserNameError(){
        return usernameError.getText();
    }
    public String getEmailError(){
        return emailError.getText();
    }
    public String getPasswordError(){
        return passwordError.getText();
    }
    public String getHeadText(){
        return headText.getText();
    }





}

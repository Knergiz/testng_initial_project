package pages;

import org.bouncycastle.crypto.tls.ExporterLabel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    //sign in page
    @FindBy(xpath = "//h1[@class=\"sds-heading--1 sds-page-section__title\"]")
    public WebElement heading1;

    @FindBy(className = "sds-page-section__title--sub signup-block")
    public WebElement paragraph;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//label[@for=\"email\"]")
    public WebElement emailLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//label[@for=\"password\"]")
    public WebElement passwordLabel;

    @FindBy(className = "sds-helper-text")
    public WebElement passwordWarning;

    @FindBy(xpath = "://a[@href=\"/forgot_password/?email=\"]")
    public WebElement forgotPassword;

    @FindBy(className = "sds-disclaimer ")
    public WebElement disclaimer;

    @FindBy(xpath = "//button[@class=\"sds-button\"]")
    public WebElement signInButton;


    //social media area
    @FindBy(className = "social-title sds-heading--3")
    public WebElement connectWithSocial;

    @FindBy(className = "sds-button facebook-button")
    public WebElement facebookLink;

    @FindBy(className = "sds-button google-button")
    public WebElement googleLink;

    @FindBy(className = "sds-button apple-button")
    public WebElement appleLink;


    //error elements
    @FindBy(className = "sds-notification__title")
    public WebElement errorHeader;

    @FindBy(className = "sds-notification__desc")
    public WebElement errorParagraph;

}

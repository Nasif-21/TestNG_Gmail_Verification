package pages;

import config.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage {

    //Locating all locators inside registation pages


    @FindBy(partialLinkText = "Register")
    public WebElement registerLink;
    @FindBy(id = "firstName")
    WebElement txtfirstname;
    @FindBy(id="lastName")
    WebElement txtlastname;
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="password")
    WebElement txtPassword;
    @FindBy(id="phoneNumber")
    WebElement txtPhoneNumber;
    @FindBy(id="address")
    WebElement txtAddress;
    @FindBy(css = "[type=radio]")
    List<WebElement> radioGender;
    @FindBy(css = "[type=checkbox]")
    WebElement checkBoxTermandCondition;
    @FindBy(id="register")
    WebElement btnRegister;

    public SignUpPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    // Calling the function for register

    public void doSignUp(UserModel userModel)
    {
        txtfirstname.sendKeys(userModel.getFirstname());
        txtlastname.sendKeys(userModel.getLastname());
        txtEmail.sendKeys(userModel.getEmail());
        txtPassword.sendKeys(userModel.getPassword());
        txtPhoneNumber.sendKeys(userModel.getPhoneNumber());
        txtAddress.sendKeys(userModel.getAddress());
        radioGender.get(0).click();
        checkBoxTermandCondition.click();
        btnRegister.click();
    }




}

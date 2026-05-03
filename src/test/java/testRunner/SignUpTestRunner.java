package testRunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpPage;
import services.Gmail_Service;
import utils.Utils;

import java.io.IOException;

public class SignUpTestRunner extends Setup {
    @Test(priority = 1, description = "Doing Sign up")
    public void userRegistration()
    {
        SignUpPage signUpPage=new SignUpPage(driver);
        //Gmail_Service gmailCheck=new Gmail_Service();
        Utils.scroll(driver,500);
        signUpPage.registerLink.click();
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email="YOUR_GMAIL_ADDRESS+"+Utils.randomNumber(100,999)+"@gmail.com";   //use your gmail account here
        String password="1234";
        String phoneNumber="0123"+Utils.randomNumber(1000000,9999999);
        String address=faker.country().capital();

        UserModel userModel=new UserModel();
        userModel.setFirstname(firstName);
        userModel.setLastname(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhoneNumber(phoneNumber);
        userModel.setAddress(address);
        signUpPage.doSignUp(userModel);
    }

    @Test(priority = 2,description = "Check the register mail")
    public void MailCheck() throws IOException, InterruptedException {
        //Add a sleep to load gmail from server, if you don't use it, its possible to get an error
        // Then assert email body and check if the latest email after registation has similar info inside it


        Thread.sleep(4000);
        Gmail_Service gmailService=new Gmail_Service();
        String myEmail=gmailService.readGmail();
        Assert.assertTrue(myEmail.contains("Welcome to our platform!"));
    }



}

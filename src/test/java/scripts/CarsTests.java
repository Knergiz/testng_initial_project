package scripts;


import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarsTests extends Base{

    @Test(priority = 1, description = "TC1: Validate Cars.com Sign in page form")
    public void testSignInPageForm(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();

        //headers
        Waiter.pause(5);
        Assert.assertEquals(signInPage.heading1.getText(), "Sign in");
        Assert.assertEquals(signInPage.paragraph.getText(), "New to Cars.com? Sign up. Are you a dealer");

        //email input box
        Assert.assertTrue(signInPage.emailInputBox.isDisplayed() && signInPage.emailInputBox.isEnabled());

        //email label
        Assert.assertTrue(signInPage.emailLabel.isDisplayed());
        Assert.assertEquals(signInPage.emailLabel.getText(), "Email");

        //password input box
        Assert.assertTrue(signInPage.passwordInputBox.isDisplayed() && signInPage.passwordInputBox.isEnabled());

        //password label
        Assert.assertTrue(signInPage.passwordLabel.isDisplayed());
        Assert.assertEquals(signInPage.passwordLabel.getText(), "Password");

        //password warning
        Assert.assertTrue(signInPage.passwordWarning.isDisplayed());
        Assert.assertEquals(signInPage.passwordWarning.getText(), "Minimum of eight characters");

        //forgot password
        Assert.assertTrue(signInPage.forgotPassword.isDisplayed() && signInPage.forgotPassword.isDisplayed());
        Assert.assertEquals(signInPage.forgotPassword.getText(), "Forgot password");

        //disclaimer
        Assert.assertEquals(signInPage.disclaimer.getText(), "“By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");
        Assert.assertTrue(signInPage.disclaimer.isDisplayed());

        //sign in button
        Assert.assertTrue(signInPage.signInButton.isDisplayed() && signInPage.signInButton.isEnabled());
        Assert.assertEquals(signInPage.signInButton.getText(), "Sign in");
    }

    @Test(priority = 2, description = "TC2: Validate Cars.com Sign in page social media section")
    public void validateSignInPageSocialMediaSection(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();

        //header
        Assert.assertEquals(signInPage.connectWithSocial.getText(), "Connect with social");

        //facebook link
        Assert.assertTrue(signInPage.facebookLink.isDisplayed() && signInPage.facebookLink.isEnabled());
        Assert.assertEquals(signInPage.facebookLink.getText(), "Sign in with Facebook");

        //google link
        Assert.assertTrue(signInPage.googleLink.isDisplayed() && signInPage.googleLink.isEnabled());
        Assert.assertEquals(signInPage.googleLink.getText(), "Sign in with Google");

        //apple link
        Assert.assertTrue(signInPage.appleLink.isDisplayed() && signInPage.appleLink.isEnabled());
        Assert.assertEquals(signInPage.appleLink.getText(), "Sign in with Apple");
    }

    @Test(priority = 3, description = "TC3: Validate user cannot sign in to Cars.com with invalid credentials")
    public void validateInvalidCredentials(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();

        //email input box
        signInPage.emailInputBox.sendKeys("johndoe@gmail.com");
        signInPage.passwordInputBox.sendKeys("abcd1234");
        signInPage.signInButton.click();

        Assert.assertEquals(signInPage.errorHeader.getText(), "We were unable to sign you in.");
        Assert.assertEquals(signInPage.errorParagraph.getText(), "Your email or password was not recognized. Try again soon.");
    }


}

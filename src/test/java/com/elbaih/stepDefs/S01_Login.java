package com.elbaih.stepDefs;

import com.elbaih.pages.P01_LoginPage;
import com.elbaih.pages.P02_ManagerHomePage;
import com.elbaih.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class S01_Login {
//@DataProvider(name = "loginCredentials")
//    public static Object[][] getDatafromDataprovider(){
//    return new String[][]
//    {
//            {"asdasd","qeqwe"}
//
//    };
//
//    };

    SoftAssert softAssert= new SoftAssert();
    WebDriver driver = Hooks.driver;
P01_LoginPage loginPage =new P01_LoginPage();
P02_ManagerHomePage mHomePage =new P02_ManagerHomePage();
WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    @Given("user go to the login page of the site {string}")
    public void userGoToTheLoginPageOfTheSite(String url) {
       driver.get(url);
    }

    @When("user enters the user name {string} and password {string}")
    public void userEntersTheUserNameAndPassword(String username, String password) {
        loginPage.userNameField.sendKeys(username);
        loginPage.passWordField.sendKeys(password);
    }

    @When("clicks the login Button")
    public void clicks_the_login_button() {
      loginPage.loginButton.click();

    }
    @Then("a {string} message is displayed")
    public void a_message_is_displayed(String managerid) {
//        wait.until(ExpectedConditions.urlContains("/manager"));
        softAssert.assertTrue(driver.getCurrentUrl().contains("/manager/Managerhomepage.php"));
        softAssert.assertTrue(driver.getTitle().contains("Manager HomePage"));
    String actualWelcomeMessage =mHomePage.welcomeMessage.getText();
        softAssert.assertTrue(actualWelcomeMessage.equalsIgnoreCase("Welcome To Manager's Page of Guru99 Bank"));
    String actualPoMessage =mHomePage.poMessage.getText();
        softAssert.assertTrue(actualPoMessage.contains(managerid));
        softAssert.assertAll();
    }
    @Then("take ascreenshot")
    public void takeAscreenshot() {
        try {
            Utils.takeSnapShot(driver,"src/test/java/com/elbaih/output/poscreenshot.png");
        } catch (Exception e) {
           e.printStackTrace();
        }
    }


    @Then("a {string} popup message is displayed")
    public void aPopupMessageIsDisplayed(String message)  {
       String actualmessage =driver.switchTo().alert().getText();
        softAssert.assertTrue(actualmessage.contains(message));
       softAssert.assertAll();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
    }


}

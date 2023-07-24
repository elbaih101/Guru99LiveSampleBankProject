package com.elbaih.stepDefs;

import com.elbaih.pages.P01_LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class S01_Login {

    SoftAssert softAssert= new SoftAssert();
    WebDriver driver = Hooks.driver;
P01_LoginPage loginPage =new P01_LoginPage();
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
    public void a_message_is_displayed(String string) {
//        wait.until(ExpectedConditions.urlContains("/manager"));
        softAssert.assertTrue(driver.getCurrentUrl().contains("/manager/Managerhomepage.php"));
     softAssert.assertTrue(driver.getTitle().contains("Manager HomePage"));
        softAssert.assertTrue(loginPage.welcomeMessage.getText().equalsIgnoreCase("Welcome To Manager's Page of Guru99 Bank"));
        softAssert.assertAll();


    }


    @Then("a {string} popup message is displayed")
    public void aPopupMessageIsDisplayed(String message) {
       String actualmessage =driver.switchTo().alert().getText();
        softAssert.assertTrue(actualmessage.contains(message));
       softAssert.assertAll();
    }
}

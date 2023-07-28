package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_LoginPage {


    public P01_LoginPage(){
        PageFactory.initElements(Hooks.driver,this);}

    @FindBy(name = "uid")
    public WebElement userNameField;
    @FindBy(name = "password")
    public WebElement passWordField;
@FindBy(name = "btnLogin")
    public WebElement loginButton;


}

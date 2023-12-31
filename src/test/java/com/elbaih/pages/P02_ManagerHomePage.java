package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_ManagerHomePage {


    public P02_ManagerHomePage(){
        PageFactory.initElements(Hooks.driver,this);}


    @FindBy(css = "tr.heading3")
   public WebElement poMessage;

    @FindBy(css = "marquee.heading3")
    public WebElement welcomeMessage;
}

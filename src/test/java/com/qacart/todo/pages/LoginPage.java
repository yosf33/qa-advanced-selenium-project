package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[id='email']")
    private WebElement inputEmail;

    @FindBy(css = "[id='password']")
    private WebElement inputPassword;

    @FindBy(css = "[id='submit']")
    private WebElement buttonSubmit;


    public TodoPage login(String email,String password) {
    inputEmail.sendKeys(email);
    inputPassword.sendKeys(password);
    buttonSubmit.click();
    return new TodoPage(driver);
}
@Step
    public LoginPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
    


}

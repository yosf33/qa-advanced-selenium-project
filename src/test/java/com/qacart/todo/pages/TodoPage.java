package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    
    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid='welcome']")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid='add']")
    private WebElement addTodoButton;

    @FindBy(css = "[data-testid='todo-item']")
    private WebElement todoItem;

     @FindBy(css = "[data-testid='delete']")
    private WebElement deleteTodoButton;

    @FindBy(css = "[data-testid='no-todos']")
    private WebElement noTodoMessage;


    @Step
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }
    @Step
    public NewTodoPage addTodoPlusButton() {
        addTodoButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String todoGetText() {
        return todoItem.getText();
    }
    @Step
    public TodoPage deleteTodoButton() {
        deleteTodoButton.click();
        return this;
    }
    @Step
    public boolean isNoTodoMessageDisplayed() {
        return noTodoMessage.isDisplayed();
    }
    @Step
    public TodoPage  load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }


}

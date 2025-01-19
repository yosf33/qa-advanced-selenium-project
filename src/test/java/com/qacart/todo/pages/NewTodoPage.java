package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {


    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-testid='new-todo']")
    private WebElement inputNewTodo;

    @FindBy(css = "button[data-testid='submit-newTask']")
    private WebElement buttonSubmitNewTask;

    @Step("submit new task from page")
    public TodoPage submitNewTask(String newTask) {
        inputNewTodo.sendKeys(newTask);
        buttonSubmitNewTask.click();
        return new TodoPage(driver);
    }
    @Step
    public NewTodoPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }


}

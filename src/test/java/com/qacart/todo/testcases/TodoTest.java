package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test(description = "Should be able to add todo correctly")
    public void shouldBeAbleToAddNewTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();

        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        String actualResult= newTodoPage
                .load()
                .submitNewTask("Learn Selenium")
                .todoGetText();


        Assert.assertEquals(actualResult, "Learn Selenium");

    }
    @Story("Delete Todo")
    @Test(description = "Should be able to delete todo correctly")
    public void shouldBeAbleToDeleteNewTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());


        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());


        boolean isNoTodoDisplayed = todoPage
                .load()
                .deleteTodoButton()
                .isNoTodoMessageDisplayed();
        Assert.assertTrue(isNoTodoDisplayed);

    }

}

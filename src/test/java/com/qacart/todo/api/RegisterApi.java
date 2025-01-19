package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RegisterApi {



    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;


    public String getUserId() {
        return userId;
    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void register() {
//        User user = new User("youssef2","soliman2","youssefsoliman2@example.com","12345678");
        User user = UserUtils.generateRandomUser();
        Response response =
                given()
                    .baseUri(ConfigUtils.getInstance().getBaseUrl())
                    .header("Content-Type","application/json")
                    .body(user)
                    .log().all()
                .when()
                        .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                        .log().all()
                        .extract().response();
        if (response.statusCode() != 201) {
        throw new RuntimeException("something went wrong with the request");
        }
        restAssuredCookies = response.detailedCookies().asList();

        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");


    }


}

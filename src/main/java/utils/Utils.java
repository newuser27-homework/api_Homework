package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasKey;

public class Utils {


    static Globals var = new Globals();

    public static String login() {
        Map<String, String> userLogin = new HashMap<>();

        userLogin.put("client_id", "fakeID");
        userLogin.put("client_secret", "fakeSecret");
        userLogin.put("code", "fakeCode");
        userLogin.put("redirect_uri", "https://stackoverflow.com/oauth");

        Response response =
                RestAssured.given().
                        header("Content-Type", "application/json").
                        body(userLogin).
                        when().
                        post(var.authLink).
                        then().
                        log().ifError().
                        statusCode(200).
                        contentType("application/vnd.api+json").
                        body("$", hasKey("authorization_token")).
                        extract().response();

        String auth_token = response.path("authorization_token").toString();
        return auth_token;
    }
}



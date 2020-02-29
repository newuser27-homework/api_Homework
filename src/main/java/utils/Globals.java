package utils;

import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;


public class Globals {
    public String url = "https://api.stackexchange.com/2.2/";
    public String pageInfo = "info/";
    public String pageUser = "users/";
    public String site = "?site=stackoverflow";

    public String userIDForUpdate = "99999";
    public String userForSchemaValidation = "999";

    public String authLink = "https://stackoverflow.com/oauth/access_token";


    public Map<String, String> newUser() {
        Map<String, String> user = new HashMap<>();
        user.put("display_name", "Marcus Downing");
        user.put("location", "United Kingdom");
        user.put("is_employee", "false");

        return user;
    }

    public Map<String, String> userUpdate(){
        Map<String, String> user = new HashMap<>();

        user.put("display_name", "Updated Name");
        user.put("location", "United Kingdom");
        user.put("is_employee", "false");

        return user;
    }

    public Map<String, String> partialUserUpdate(){
        Map<String, String> user = new HashMap<>();

        user.put("display_name", "Patch Name");

        return user;
    }


}

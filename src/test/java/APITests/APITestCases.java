package APITests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import utils.Globals;
import utils.Utils;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APITestCases {

    private Globals var = new Globals();

    @Before
    public void setup() {
    }

    @After
    public void afterTest (){
    }


    @Test
    public void makeSureSiteIsUp() {
        given()
                .when()
                .get(var.url+var.pageInfo+var.site)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void jsonSchemaValidationTest() {
        given()
                .when()
                .get(var.url+var.pageUser+var.userForSchemaValidation+var.site)
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("resources/singleUser.json"));
    }

    @Test
    public void testingPostCall(){


        given()
                .auth()
                .oauth2(Utils.login())
                .contentType("application/json")
                .body(var.newUser())
                .when()
                .post(var.url+var.pageUser+var.site)
                .then()
                .statusCode(201);
    }

    @Test
    public void testingPutCall(){
        given()
                .auth()
                .oauth2(Utils.login())
                .contentType("application/json")
                .body(var.userUpdate())
                .when()
                .put(var.url+var.pageUser+var.userIDForUpdate+var.site)
                .then()
                .statusCode(200);
    }
    @Test
    public void testingDeleteCall(){
        given()
                .auth()
                .oauth2(Utils.login())
                .contentType("application/json")
                .delete(var.url+var.pageUser+var.userIDForUpdate+var.site)
                .then()
                .statusCode(200);
    }

    @Test
    public void testingPatchCall(){
        given()
                .auth()
                .oauth2(Utils.login())
                .contentType("application/json")
                .when()
                .patch(var.url+var.pageUser+var.userIDForUpdate+var.site, var.partialUserUpdate())
                .then()
                .statusCode(200);
    }
}



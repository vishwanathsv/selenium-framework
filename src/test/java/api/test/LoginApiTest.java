package api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTest {

    @Test
    public void testLogin() {

        String requestBody = "{\n" +
                "  \"email\": \"eve.holt@reqres.in\",\n" +
                "  \"password\": \"cityslicka\"\n" +
                "}";

        Response response =
                given()
                        .baseUri("https://reqres.in")   // ✅ FORCE OLD API
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .post("/api/login")              // ✅ correct endpoint
                        .then()
                        .extract().response();

        System.out.println("Response: " + response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        String token = response.jsonPath().getString("token");
        System.out.println("Token: " + token);

        Assert.assertNotNull(token);
    }
}
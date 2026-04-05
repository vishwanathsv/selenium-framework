package api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestVerify {
    @Test
    public void makeLogin() {
        Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json").body("{\"username\":\"uday123\",\"password\":\"uday123\"}").post("/api/auth/login");
        System.out.println("Response : " + response.asString());
        Assert.assertEquals(response.getStatusCode(), 200);


    }

}

package api.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiBaseTest {

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    // Base URL (change this to your API)
    public static String baseUrl = "https://reqres.in";

    static {

        // -------------------------
        // REQUEST SPECIFICATION
        // -------------------------
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();

        // -------------------------
        // RESPONSE SPECIFICATION
        // -------------------------
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
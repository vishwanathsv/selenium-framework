package api.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigReader;

public class ApiBaseTest {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    public static RequestSpecification getRequestSpec() {

        if (requestSpec == null) {

            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(ConfigReader.get("api.baseUrl"))
                    .setContentType(ContentType.JSON)
                    .addHeader("Accept", "application/json")

                    .addFilter(new RequestLoggingFilter())
                    .addFilter(new ResponseLoggingFilter())

                    .build();
        }

        return requestSpec;
    }


    public static ResponseSpecification getResponseSpec() {

        if (responseSpec == null) {

            responseSpec = new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .build();
        }

        return responseSpec;
    }
}
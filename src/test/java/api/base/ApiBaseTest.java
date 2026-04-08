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
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    public static RequestSpecification getRequestSpecification() {
        if (requestSpecification == null) {
            requestSpecification = new RequestSpecBuilder().setBaseUri(ConfigReader.get("api.baseUrl")).setContentType(ContentType.JSON).addHeader("Accept", "application/json").addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter()).build();

        }
        return requestSpecification;

    }

    public static ResponseSpecification getResponseSpecification() {
        if (responseSpecification == null) {
            responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        }
        return responseSpecification;
    }

}


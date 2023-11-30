import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    static final String debian = "http://abdd-debian-10.nd.local";
    static final String nord = "http://abdd-test.norddig.ru";
    static final String test70 = "http://172.16.20.70/";
    static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(test70)
            .build();
}

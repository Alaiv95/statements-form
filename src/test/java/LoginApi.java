import static io.restassured.RestAssured.given;

public class LoginApi extends BaseApi{
    public static String loginAsUserAndGetToken()  {
        String reqBody = "{\"login\": \"road-user\", \"password\": \"road-user\"}";

        return given()
                .spec(requestSpecification)
                .header("Content-type", "application/json")
                .and()
                .body(reqBody)
                .post("/api/auth/login")
                .then().extract().response()
                .jsonPath().getString("data.token");
    }
}

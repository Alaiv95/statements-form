import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StatementApi extends BaseApi {
    String token = LoginApi.loginAsUserAndGetToken();

    public Response fromStatement(String type) {
        String reqBody = getJson();
        String url = String.format("/api/statements/%s/report", type);

        return given()
                .spec(requestSpecification)
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .and()
                .body(reqBody)
                .post(url)
                .then().extract().response();
    }

    private String getJson() {
        return """
                {
                    "date": "2023-11-30T07:50:38.431Z",
                    "dateFrom": "2022-11-30T07:13:38.431Z",
                    "roadTypes": [],
                    "roads": [],
                    "subjects": [
                        "dc9990c2-9d75-4bb5-9666-adb83d8c9ce9",
                        "fbfec66a-7a2a-4f99-9b28-24bbdf6fce3a",
                        "b276c71a-e3f2-4df6-9ecb-8ed31a48f796",
                        "0f316bdf-c0c7-43d3-9769-fc850ff584b7",
                        "a5935ccb-535d-44ee-9386-5c950fc1d8d8",
                        "dccdda77-ec83-4ca5-909c-91a4eb8a434a",
                        "00f1235f-0f55-4440-b655-40126ff9d828",
                        "fabbaaaf-d328-4a7a-bf1f-5b0c8eb16b9b",
                        "0a21bfe4-7e65-4018-a496-d4bd3e3f3b8c",
                        "3fb65881-76cf-4d54-80ed-ccb576ff1a87",
                        "3d669a0e-3b83-4c0d-937c-9da852887a24",
                        "eb314a24-3b6c-44be-ae4b-dd62efcada10",
                        "62751086-762e-46d3-9422-e2dcfcea5277",
                        "5716eabe-2376-4820-92e0-4c13d8b831d7",
                        "db7ab8e2-3be8-40d2-8987-b5c111f8cc6a",
                        "08950ea0-06dc-4038-b6a9-77a7cbd9fd10",
                        "487426fd-9852-49c2-b5a0-e183d89e06de",
                        "b1abdcb7-6738-4909-9dc6-2fbf0837f710",
                        "617a5cb8-9a21-415d-996e-d63256aa202a",
                        "174407bd-16fb-4fd3-be37-4d7d9b1b5c1e",
                        "16d3ec7a-06aa-4c8f-9f7b-17529110c903",
                        "316cf483-0ef2-40c7-9d09-72025cb5a2b3",
                        "3311e0e6-deec-42de-8fa8-2c2cde2e6dfe",
                        "a12a89e1-1db0-4d8c-bfa5-bf8b3d141841",
                        "9ae7fcd5-8c44-4ecb-97cb-781518d3ae21",
                        "5a5ad2bd-1caa-4fb8-8cad-32110a8dd2de",
                        "084e3c85-aec5-454f-bad3-1c640dd69703",
                        "c11081f9-c458-4481-8e45-bcb1bef0a21e",
                        "d0b3f1fb-a43c-4ce4-9344-00a4078d4dbf",
                        "ba883c25-cffd-46bc-91bf-66d1c8147015",
                        "c1cfaef6-e6ab-4812-a335-659751ec1746"
                    ],
                    "agglomerations": [],
                    "fkus": [],
                    "mtks": [],
                    "diagnosticTypes": [],
                    "startKm": 0,
                    "startM": 0,
                    "endKm": 0,
                    "endM": 0,
                    "page": 0,
                    "sortingOption": [],
                    "filteringOptions": []
                }""";
    }
}

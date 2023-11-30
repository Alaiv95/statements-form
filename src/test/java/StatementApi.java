import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StatementApi extends BaseApi {
    String token = LoginApi.loginAsUserAndGetToken();

    public Response formReport(String type) {
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
                    "date": "2023-11-30T09:41:43.500Z",
                    "dateFrom": "2022-11-30T09:02:43.499Z",
                    "roadTypes": [],
                    "roads": [],
                    "subjects": [
                        "37abb29b-0a2c-40e6-9a9f-aa44e1197c79",
                        "3d669a0e-3b83-4c0d-937c-9da852887a24",
                        "3fb65881-76cf-4d54-80ed-ccb576ff1a87",
                        "463ef403-aeab-487d-94f2-9436f8a5067e",
                        "487426fd-9852-49c2-b5a0-e183d89e06de",
                        "52fceb87-21af-4616-b738-421e5939d51f",
                        "5471650d-7c52-437f-9d1c-f7a5663dfa4e",
                        "56b54795-029b-40cd-9248-c9c13248bc62",
                        "56f2c9b7-088a-495f-b9c0-d42502550768",
                        "5716eabe-2376-4820-92e0-4c13d8b831d7",
                        "5a5ad2bd-1caa-4fb8-8cad-32110a8dd2de",
                        "5d7b4795-7f3a-45f4-a338-4da6337b2297",
                        "5ddc7563-0296-4f77-ad66-401d27b6aacd",
                        "617a5cb8-9a21-415d-996e-d63256aa202a",
                        "62751086-762e-46d3-9422-e2dcfcea5277",
                        "62e1f091-75fb-47bc-b739-887969c2ac08",
                        "6919e63b-4675-4cac-8da0-56b71ebd468f",
                        "6bb9c85b-2c91-4121-8462-3a4598223299",
                        "7219d000-8b05-4980-9946-1b9feacae5fd",
                        "746d0335-2d5b-4fd7-8051-dc2e2ef9ec03",
                        "7483f625-2681-49e9-8112-9e2060296045",
                        "7fadf881-bd23-432e-9085-7c721edb64be",
                        "87b321df-71fe-4869-8efe-c5cd08e9a10b",
                        "93b70bda-63cd-4bc6-bfa1-bfbf8cfc1916",
                        "96f7dc08-d11d-4287-be54-8b59c7c4f20d",
                        "97916f06-82ef-4996-bf3e-5bd9c9cbf389",
                        "998501b5-753d-4788-9949-857ffd09d73a",
                        "9ae7fcd5-8c44-4ecb-97cb-781518d3ae21",
                        "a12a89e1-1db0-4d8c-bfa5-bf8b3d141841",
                        "a46dbbf0-82ec-4147-97ae-c1984dbc747c",
                        "a5935ccb-535d-44ee-9386-5c950fc1d8d8",
                        "a77d4d75-2d51-490c-81c1-5de5178bdbb0",
                        "a915c7e5-325e-4c81-a96a-c5ab532c2a00",
                        "a93a2389-3e36-4b2d-99ea-b5dbf4c58441",
                        "aa756d96-3d56-478e-92cf-8dabb00fbe6f",
                        "aaaee9c5-c6d6-4c2b-86d8-b215e7310d3f",
                        "ae4a25a5-8478-42a6-9bc9-f681cf3fd570",
                        "dccdda77-ec83-4ca5-909c-91a4eb8a434a",
                        "df6f834a-aef4-4045-8bbb-6455b169a1e0",
                        "dfaa5d0b-931d-4d91-8f84-dfa7663f73f7",
                        "00f1235f-0f55-4440-b655-40126ff9d828",
                        "084e3c85-aec5-454f-bad3-1c640dd69703",
                        "08950ea0-06dc-4038-b6a9-77a7cbd9fd10",
                        "0a21bfe4-7e65-4018-a496-d4bd3e3f3b8c",
                        "0f316bdf-c0c7-43d3-9769-fc850ff584b7",
                        "158978c4-6c3f-47d1-bc14-c17f4f95497e",
                        "16d3ec7a-06aa-4c8f-9f7b-17529110c903",
                        "174407bd-16fb-4fd3-be37-4d7d9b1b5c1e",
                        "1bbe1e5d-8098-42b0-b977-18e934981a82",
                        "1cf0cea6-739f-4e79-9515-c3631d193fae",
                        "2036bc81-ba37-4888-9c21-1b367cae3061",
                        "2a12d494-c680-462d-9167-08499e1a975c",
                        "e77959d2-f975-4605-bb40-a918515b6b14",
                        "316cf483-0ef2-40c7-9d09-72025cb5a2b3",
                        "3311e0e6-deec-42de-8fa8-2c2cde2e6dfe",
                        "33199302-796f-44b5-9922-30f85efb33c3",
                        "35fa1d33-fd5f-4e90-8da3-2292723ecb8c",
                        "b1abdcb7-6738-4909-9dc6-2fbf0837f710",
                        "b276c71a-e3f2-4df6-9ecb-8ed31a48f796",
                        "b35b5afd-c984-4b85-a350-20142724ac83",
                        "b4ebb1c3-7687-4cdb-8fb7-3175d9e513f9",
                        "b8cefbe8-636c-4eb4-a162-6f7ce3212d27",
                        "ba883c25-cffd-46bc-91bf-66d1c8147015",
                        "c11081f9-c458-4481-8e45-bcb1bef0a21e",
                        "c1cfaef6-e6ab-4812-a335-659751ec1746",
                        "d0b3f1fb-a43c-4ce4-9344-00a4078d4dbf",
                        "d0ef6de4-5f0b-4883-8d5d-af3fd6ab9c7c",
                        "d640ddce-b5f6-4ca1-ac5e-ceeed3657e6d",
                        "db7ab8e2-3be8-40d2-8987-b5c111f8cc6a",
                        "dbbd8f08-966c-4ea3-8545-b1ecc9ec2666",
                        "dc9990c2-9d75-4bb5-9666-adb83d8c9ce9",
                        "eb314a24-3b6c-44be-ae4b-dd62efcada10",
                        "ec5e774f-ab47-4b1d-a6fc-61370d2edaab",
                        "ee9235f2-160c-44d0-aac7-1429fb6524ab",
                        "f6ffe0f8-a935-4d24-a162-d18bee67f307",
                        "f78d09ff-86c4-4ded-a571-cd020449b3b7",
                        "f89a2b8a-a2da-40d2-819e-4584f544e55d",
                        "fabbaaaf-d328-4a7a-bf1f-5b0c8eb16b9b",
                        "fbfec66a-7a2a-4f99-9b28-24bbdf6fce3a",
                        "fe445b1b-99c4-4b23-9e2b-8b2d168e42b3",
                        "36c0ca87-987b-4152-9047-999f5371d44c",
                        "b086cd0d-b8c7-4f42-a87d-509fa07edca0",
                        "9f2b627c-4a02-4cad-a725-5186f58fbede"
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

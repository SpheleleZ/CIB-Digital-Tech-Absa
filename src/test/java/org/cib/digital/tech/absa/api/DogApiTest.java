package org.cib.digital.tech.absa.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DogApiTest {

    @Test
    public void getRequestToProduceAListOfAllBreedsDog() {
        baseURI = "https://dog.ceo/api/";

        given()
                .contentType(ContentType.JSON)
                .pathParam("myPath", "breeds")
                .pathParam("myPath1", "list")
                .pathParam("myPath2", "all")
                .when()
                .get("{myPath}/{myPath1}/{myPath2}")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void verifyRetrieverBreedIsWithinTheList() {

        baseURI = "https://dog.ceo/api/";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .pathParam("myPath", "breeds")
                        .pathParam("myPath1", "list")
                        .pathParam("myPath2", "all")
                        .when()
                        .get("{myPath}/{myPath1}/{myPath2}");

        JSONObject jsonObject = new JSONObject(response.asString());

        String message = jsonObject.getJSONObject("message").toString();

        String retrieve = "retrieve";
        if (message.contains(retrieve)) {
            System.out.println("Verify - " + retrieve + " is within List");
        }
    }

    @Test
    public void getRequestToProduceAListOfSubBreedsForRetriever(){

        baseURI = "https://dog.ceo/api/";

        given()
                .contentType(ContentType.JSON)
                .pathParam("myPath", "breed")
                .pathParam("myPath1", "retriever")
                .pathParam("myPath2", "list")
                .when()
                .get("{myPath}/{myPath1}/{myPath2}")
                .then()
                .statusCode(200)
                .log().body();
    }
}

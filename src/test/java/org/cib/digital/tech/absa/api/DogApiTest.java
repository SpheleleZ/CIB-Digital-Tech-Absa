package org.cib.digital.tech.absa.api;

import io.restassured.http.ContentType;
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
}

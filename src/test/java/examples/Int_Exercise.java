package examples;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import payload.RahulPayloads;

import static io.restassured.RestAssured.given;

public class Int_Exercise {
    @Test
    public void getUser() {
        RestAssured.baseURI = " ";
        given().log().all().body(RahulPayloads.addNewPlacePayload()).queryParam("key", "qaclick123").
                when().post("/maps/api/place/add/json").
                then().log().all().statusCode(200);


    }
}

package examples;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.RahulPayloads;
import util.ConfigReader;
import util.TestUtil;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POST_GET extends TestUtil {

    @Test
    public void createPlacePOST() {    //  POST
        // BDD approach
        // given() --> we put details to create a request
        // when() --> http method and path parameter
        // then() --> Validations
        createRequestRahul().body(RahulPayloads.addNewPlacePayload2());
        executeAPI("POST", ConfigReader.getProperty("postParamRahul"));
        responseSpecification(200);
        getResponse();
    }

    @Test
    public void getPlace() {    //  GET
        createRequestRahul().queryParam("place_id", "ff588ae41beb8ef670ee2b44ef76fa97" );
        executeAPI("GET", ConfigReader.getProperty("getPathParamRahul"));
        responseSpecification(200);
        getResponse();
        Response response = getResponse();
        JsonPath js = getJsonPath(response);
        Assert.assertEquals(js.getString("name"), "Pink House");
        Assert.assertEquals(js.getString("location.latitude"),"-23.122");



        // We use jsonpath to do validation
//        JsonPath js = new JsonPath(response);
//        String actualName = js.getString("name");
//        Assert.assertEquals(actualName, "Snowy House");
//        int lat = js.getInt("location.latitude");
//        Assert.assertEquals(lat, -10);

    }

    @Test
    public void getPlaceHamcrestValidation() {    //  GET
        createRequestRahul().queryParam("place_id", "ff588ae41beb8ef670ee2b44ef76fa97");
        executeAPI("GET", ConfigReader.getProperty("getPathParamRahul"));
        responseSpecification(200);
        getResponseHamcrest("name", "Pink House");
        getResponseHamcrest("address", "1123.street");




//        RestAssured.baseURI = "https://rahulshettyacademy.com";
//        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "4159b9f72fc14927a747e262ce1190d2").
//                when().get("/maps/api/place/get/json").
//                then().log().all().statusCode(200).
//                body("name", equalTo("Snowy House")).
//                body("address", equalTo("100, small street, cohen 18"));

        // We use HamcrestMatcher Validation this is the second way   equalTo()

    }

    @Test
    public void updateInfo() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").body(RahulPayloads.addNewPlacePayload()).
//                body("{\n" +
//                        "\"place_id\":\"d2d2020d380f84d3d3df7790411ed70d\",\n" +
//                        "\"address\":\"105 Winter walk, USA\",\n" +
//                        "\"key\":\"qaclick123\"\n" +
//                        "}\n").

                when().put("/maps/api/place/update/json").
                then().log().all().statusCode(200);

    }

    @Test
    public void getUpdatedInfo() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "d2d2020d380f84d3d3df7790411ed70d").
                when().get("/maps/api/place/get/json").
                then().log().all().statusCode(200);


    }

    @Test
    public void deleteInfo(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").queryParam("place_id","928b51f64aed18713b0d164d9be8d67f").
                when().delete("/maps/api/place/delete/json").
                then().log().all().statusCode(200);
    }
    @Test
    public void createNewPlaceWithPojo(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().body(RahulPayloads.addNewPlacePayload2()).queryParam("key", "qaclick123").queryParam("name", "Pink House").
                when().get("/maps/api/place/add/json").
                then().log().all().statusCode(200);

    }


}

package examples;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.matcher.DetailedCookieMatcher;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.GoRestPayloads;
import util.TestUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class GoRestRequestAndResponseSpecifications extends TestUtil {

    @Test
    public void getUsers() {  // get --> retrieving information
       // createRequest().when().get("/public-api/users").then().log().all().spec(responseSpecification(200));

        createRequest(); //  eger specific birini ariyorsak request bolumune ( createRequest().queryParam("id", 1702); ) bu sekilde yaziyoruz
        executeAPI("GET", "/public-api/users");
        responseSpecification(200);

    // Validation yapmak istiyorsak alttaki parti aktif hale getirip yukarda createRequestten sonra queryParam eklememiz lazim
        Response response = getResponse();
        JsonPath js = getJsonPath(response);
        Assert.assertEquals(js.getString("data[0].name"), "Shanti Rana");

    }
    @Test
    public void getSingleUser() {  // get --> retrieving information

        createRequest().queryParam("id", 1702); //  eger specific birini ariyorsak request bolumune yaziyoruz
        executeAPI("GET", "/public-api/users");
        responseSpecification(200);

        Response response = getResponse();
        JsonPath js = getJsonPath(response);
        Assert.assertEquals(js.getString("data[0].name"), "Emily");

    }

    @Test
    public void createUser() {

        createRequest().body(GoRestPayloads.createUserPayload2());
        executeAPI("POST", "/public-api/users");
        responseSpecification(200);
        getResponse();


    }
    @Test
    public void updateUser() {

        createRequest().queryParam("name", "Hayriye").queryParam("gender", "Female") ;               //    body(GoRestPayloads.updateUserPayload());
        executeAPI("PUT", "/public-api/users/1750");
        responseSpecification(200);
        getResponse();


    }
    @Test
    public void deleteUser() {

        createRequest().body(GoRestPayloads.updateUserPayload());
        executeAPI("DELETE", "/public-api/users/14");
        responseSpecification(200);
        getResponse();


    }


}
//  GET
// createRequest().when().get("/public-api/users").then().log().all().spec(responseSpecification(200));
//  POST
// createRequest().body(GoRestPayloads.updateUserPayload()).when().put("/public-api/users").then().log().all().spec(responseSpecification(200));
//  PUT
// createRequest().queryParam().when().put("/public-api/users").then().log().all().spec(responseSpecification(200));
//  DELETE
// createRequest().queryParam().when().delete("/public-api/users").then().log().all().spec(responseSpecification(200));











//        BDD approach
//        given()--> we create our request with details-->headers,query parameters,body
//        when()-->http type(get,post,put,...) and execute the request
//        then()--> getting response and do some validation(JsonPath, Hamcrest matcher, deserilization)
//
//        RestAssured.baseURI="https://gorest.co.in";
//         bu part request oluyor
//        given().log().all().header("Accept", "application/json").header("Content-Type","application/json").
//                header("Authorization","Bearer 7e1c9afacd1c18c964f240791586799dfb70adae424fef3d612e937e9714819e").
//                when().get("/public-api/users").
//                then().log().all().statusCode(200);   // tum userlari getir



        // we are dizagning with speckbuilder, how our request look like
        // requestspecification is interface
        // RequestSpecification designates how the request looks like
//        RequestSpecification request = given().log().all().spec(new RequestSpecBuilder().setBaseUri("https://gorest.co.in").
//                addHeader("Accept", "application/json").
//                addHeader("Authorization","Bearer 7e1c9afacd1c18c964f240791586799dfb70adae424fef3d612e937e9714819e").
//                setContentType(ContentType.JSON).build());
//
//        // ResponseSpecification designates how the response looks like
//         ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//                request.when().get("/public-api/users").then().log().all().spec(response);




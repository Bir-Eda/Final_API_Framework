package examples;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.GoRestPayloads;

import static io.restassured.RestAssured.given;

public class GoRestAPI_IkinciHali {
     // String token;  globel yapabiliriz
//    @BeforeTest
//    public void setUp(){
//        RestAssured.baseURI="https://gorest.co.in";
//        String response=
//    }

    @Test
    public void goGetUsers(){  // get --> retrieving information

        RestAssured.baseURI="https://gorest.co.in";
        given().log().all().header("Accept", "application/json").header("Content-Type","application/json").
                header("Authorization","Bearer 7e1c9afacd1c18c964f240791586799dfb70adae424fef3d612e937e9714819e").
                when().get("/public-api/users").
                then().log().all().statusCode(200);   // tum userlari getir




    }
    @Test
    public void goGetSingleUser(){  // get --> retrieving information

        RestAssured.baseURI="https://gorest.co.in";
        String response=given().log().all().header("Accept", "application/json").header("Content-Type","application/json").
                header("Authorization","Bearer 7e1c9afacd1c18c964f240791586799dfb70adae424fef3d612e937e9714819e").queryParam("id",28).
                when().get("/public-api/users").
                then().log().all().statusCode(200).extract().asString();
        // id`si 27 olani getir

        //  JsonPath ile validation
        JsonPath json=new JsonPath(response);  // buraya given kismini uzun uzun yazmak yerine giveni stringe atiyoruz ve response  u buraya yaziyoruz

        String actualName= json.getString("data[0].name");
        Assert.assertEquals(actualName, "Manoj Adiga I");

        int actualimit=json.getInt("meta.pagination.limit");
        Assert.assertEquals(actualimit, 20);

    }
    @Test
    public void createUser(){   //  create yaparken body`ye ihtiyacimiz var
        RestAssured.baseURI="https://gorest.co.in";

        given().log().all().header("Accept", "application/json").header("Content-Type","application/json").
                header("Authorization","Bearer 7e1c9afacd1c18c964f240791586799dfb70adae424fef3d612e937e9714819e").
                body(GoRestPayloads.createUserPayload2()).
                when().post("/public-api/users").then().log().all().statusCode(200);

    }

    @Test
    public void updateSingleUser(){  //  specific bir bilgi degistiricez o yuzden queryParam ekliyoruz yani id si su olani degistir deyip bodynin icinde degisiklik yapiyoruz ama burda (/public-api/users/2239) ile parantez icine yaziyoruz
        RestAssured.baseURI="https://gorest.co.in";
        given().log().all().header("Accept", "application/json").header("Content-Type","application/json").
                header("Authorization","Bearer 7e1c9afacd1c18c964f240791586799dfb70adae424fef3d612e937e9714819e").
                body(GoRestPayloads.updateUserPayload()).
                when().put("/public-api/users/2271").then().log().all();

    }

    @Test
    public void deleteSingleUser(){  //  specific bir bilgi degistiricez o yuzden queryParam ekliyoruz  (/public-api/users/2239) buranin icine id yazarsak query olarak ayrica yazmaya gerek yok
        RestAssured.baseURI="https://gorest.co.in";
        given().log().all().header("Accept", "application/json").header("Content-Type","application/json").
                header("Authorization","Bearer 7e1c9afacd1c18c964f240791586799dfb70adae424fef3d612e937e9714819e").
                when().delete("/public-api/users/2271").then().log().all().statusCode(200);

    }
    // {} Object
    // [] Array
























}

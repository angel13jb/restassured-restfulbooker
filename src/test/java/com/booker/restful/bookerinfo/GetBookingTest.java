package com.booker.restful.bookerinfo;

import com.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBookingTest extends TestBase {

    @Test
    public void getAllBookingData(){
        Response response=given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getSingleBookingData(){
        Response response=given()
                .pathParam("id","2456")
                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}

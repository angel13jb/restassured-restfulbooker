package com.booker.restful.bookerinfo;

import com.booker.restful.model.PartialUpdatePojo;
import com.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchBookingTest extends TestBase {

    @Test
    public void partialUpdateBooking(){

        PartialUpdatePojo partialUpdatePojo=new PartialUpdatePojo();
        partialUpdatePojo.setFirstname("Tom");
        partialUpdatePojo.setLastname("cat");

        Response response = given()
                .header("Cookie", "token=7d2560157cb4343")
                .header("Content-Type", "application/json")
                .pathParam("id", "3083")
                .body(partialUpdatePojo)
                .when()
                .patch("/booking/{id}");
         response.then().statusCode(200);
        response.prettyPrint();

    }
}

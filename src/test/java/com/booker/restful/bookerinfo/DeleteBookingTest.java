package com.booker.restful.bookerinfo;

import com.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends TestBase {
    @Test
    public void deleteBookingData(){
        Response response=given()
                .header("Cookie", "token=d17bdd0a99f32c3")
                .header("Content-Type", "application/json")
                .pathParam("id", "3083")
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}

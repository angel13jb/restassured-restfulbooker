package com.booker.restful.bookerinfo;


import com.booker.restful.model.UpdatePojo;
import com.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutBookingTest extends TestBase {

    @Test
    public void updateBookingData() {
        UpdatePojo updatePojo = new UpdatePojo();
        updatePojo.setFirstname("Jully");
        updatePojo.setLastname("smith");
        updatePojo.setTotalprice(300);
        updatePojo.setDepositpaid(false);
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2018-01-01");
        bookingsDatesData.put("checkout", "2019-01-01");
        updatePojo.setBookingdates(bookingsDatesData);
        updatePojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Cookie", "token=d17bdd0a99f32c3")
                .header("Content-Type", "application/json")
                .pathParam("id", "2305")
                .body(updatePojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}

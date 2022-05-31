package com.booker.restful.bookerinfo;

import com.booker.restful.model.AuthPojo;
import com.booker.restful.model.CreatePojo;
import com.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostBookingTest extends TestBase {

    @Test
    public void gerAuthenticationToken() {

        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password123");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(authPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    //d17bdd0a99f32c3
    @Test
    public void createBookingData(){
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2018-01-01");
        bookingsDatesData.put("checkout", "2019-01-01");


        CreatePojo createPojo =new CreatePojo();
        createPojo.setFirstname("Jony");
        createPojo.setLastname("Brown");
        createPojo.setTotalprice(123);
        createPojo.setDepositpaid(true);
        createPojo.setBookingdates(bookingsDatesData);

        createPojo.setAdditionalneeds("Breakfast");

        Response response=given()
                .header("Cookie", "token=7d2560157cb4343")
                .header("Content-Type", "application/json")
                .body(createPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}

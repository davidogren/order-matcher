package com.redhat.sa;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class TickerResourceTest {

    @BeforeAll
    static void setup() {
        System.out.println("TODO: Reset database"); //TODO: Reset database
    }

    @Test
    public void testGetQuote() {
        System.out.println("output test"); //TODO: Reset database
        given()
                .when().get("/quote/IBM")
                .then()
                .statusCode(200)
                .body("name", equalTo("IBM (dev mode)"))
                .body("bid", equalTo(49.0f));
    }

    @Test
    public void testGetQuoteUnknownTicker() {
        System.out.println("output test"); //TODO: Reset database
        given()
                .when().get("/quote/FRED")
                .then()
                .statusCode(404);
    }

    @Test
    public void testGetQuoteExpectedMethod() {
        System.out.println("output test"); //TODO: Reset database
        given()
                .when().post("/quote/IBM")
                .then()
                .statusCode(405);
    }

        //TODO: Test for different views (with more and less information) once we have more detailed data
}
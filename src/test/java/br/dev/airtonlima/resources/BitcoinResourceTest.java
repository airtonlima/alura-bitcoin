package br.dev.airtonlima.resources;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
class BitcoinResourceTest {
    @Test
    public void testIfStatusCodeIsOK() {
        RestAssured.given().get("bitcoins").then().statusCode(200);
    }
}
package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.model.Order;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class HomeTaskApiTest {
    @BeforeClass
    public void prepare() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", System.getProperty("api.key"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.filters(new ResponseLoggingFilter());
    }

    @Test
    public void testOrder() throws InterruptedException {
        Order order = new Order();
        int id = new Random().nextInt(10);
        int petId = new Random().nextInt(50);;
        order.setId(id);
        order.setPetId(petId);
        order.setQuantity(1);
        order.setComplete(false);

        given()
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200);

        Order orderGet =
                given()
                        .pathParam("id", id)
                        .when()
                        .get("/store/order/{id}")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Order.class);

        Assert.assertEquals(order.getId(), orderGet.getId());

        given()
                .pathParam("id", id)
                .when()
                .delete("/store/order/{id}")
                .then()
                .statusCode(200);

        given()
                .pathParam("id", id)
                .when()
                .get("/store/order/{id}")
                .then()
                .statusCode(404);

        Map inventory =
                given()
                        .when()
                        .get("/store/inventory")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Map.class);

        Assert.assertTrue(inventory.containsKey("sold"), "Inventory не содержит статус sold" );
    }
}

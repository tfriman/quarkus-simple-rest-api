package timotest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        String result = given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .extract().response().body().path("message");
        Assertions.assertEquals("hello", result);
    }

}
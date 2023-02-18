package tests;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemowebshopTests {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }

    @Test
    void changeCountryShippingToCartTest() {
        given()
                .cookie("Nop.customer","51f7aca9-65bf-49c5-a4f6-90cd364d2c6f")
                .when()
                .get("/country/getstatesbycountryid?countryId=87&addEmptyStateIfRequired=true&_=1676637499942")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", hasItem(0))
                .body("name",hasItem("Other (Non US)"));

    }
}




// https://catfact.ninja/fact

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


public class CatFactApiTest {

    /**
     * Testing a cat fact from https://catfact.ninja/fact
     * GET request returns json in the following format:
     * {
     * "fact": "some fact about cat",
     * "length": x
     * }
     * where x > 0
     */
    @Test
    public void testGetACatFact() {
        given()
                .when()
                .get("https://catfact.ninja/fact")
                .then()
                .statusCode(200)
                .body("fact", is(not(emptyString())))
                .and().body("length", greaterThan(0));
    }
}

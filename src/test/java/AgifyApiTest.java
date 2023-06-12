import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Class that tests the api that predicts the age based on name: https://api.agify.io/?name=xxx
 */
public class AgifyApiTest {

    @Test
    public void whenPredictingAgeWithoutName_thenError() {
        given()
        .when()
        .get("https://api.agify.io/")
        .then()
        .statusCode(422)
        .body("error", is("Missing 'name' parameter"));
    }

    @Test
    public void whenPredictingAgeWithName_thenSuccess() {
        given().queryParam("name", "Natalie")
                .when()
                .get("https://api.agify.io/")
                .then()
                .statusCode(200)
                .body("age", greaterThan(0));
    }
}


package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    public static String token;

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {

        RequestSpecification generateTokenRequest = given().header("Content-Type","application/json").body("{\n" +
                "  \"email\": \"abc123@bcc.com\",\n" +
                "  \"password\": \"hello\"\n" +
                "}");

        Response generatedTokenReponse = generateTokenRequest.when().post("/generateToken.php");
        generatedTokenReponse.prettyPrint();

        token = "Bearer " + generatedTokenReponse.jsonPath().getString("token");
        System.out.println(token);
    }
}

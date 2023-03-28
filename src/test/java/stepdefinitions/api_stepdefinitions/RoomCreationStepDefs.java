package stepdefinitions.api_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.Room;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;


public class RoomCreationStepDefs {
    Response response;
    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {
      //set the url
spec.pathParams("first","api","second","rooms");
//set the expected Data
        Room exceptedData=new Room("King romms",1478526,69786,"TWIN",true);
        //send the request and response

    response=given().spec(spec).body(exceptedData).post("{first}/{second}");
       response.prettyPrint();
    }
    @Then("user gets the room data and assert")
    public void user_gets_the_room_data_and_assert() {

    }

}

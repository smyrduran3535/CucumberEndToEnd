package stepdefinitions.api_stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.Room;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class MyRoomCreationStepDefs {
    float roomNumber=new Faker().number().numberBetween(1000,1000000);
    Room expectedData;
    Response response;
    @Given("admin sends post request for room data")
    public void admin_sends_post_request_for_room_data() {

        //Set the url
        spec.pathParams("first", "api", "second", "rooms");
         //set the expectedData
       expectedData=new Room(
                "DON'T MISS!! Discount on daily accommodation price",
                1000000,
                roomNumber,
                "DAYCARE",
                true
                );
        //send the request and response
        response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

    }
    @Then("admin gets the room data and assert")
    public void admin_gets_the_room_data_and_assert() {
Room actualData=response.as(Room.class);
assertEquals(201,response.statusCode());
assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
assertEquals(expectedData.getRoomType(),actualData.getRoomType());
assertEquals(expectedData.getPrice(),actualData.getPrice());
assertEquals(expectedData.getStatus(),actualData.getStatus());
assertEquals(expectedData.getDescription(),actualData.getDescription());
    }


}

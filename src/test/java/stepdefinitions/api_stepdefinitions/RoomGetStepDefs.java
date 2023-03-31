package stepdefinitions.api_stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Room;

import java.io.IOException;
import java.util.List;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.MedunnaRoomStepDefs.roomNumber;

public class RoomGetStepDefs {
    @Given("user sends get request and validate")
    public void user_sends_get_request_and_validate() throws IOException {
        //Set the url
        //https://medunna.com/api/rooms?sort=createdDate,desc
        spec.pathParams("first","api","second","rooms").
                queryParam("sort","createdDate,desc");
        //Set the expected data
        Room expectedData = new Room("Created By Selenium For Api Test",123,roomNumber,"SUITE",true);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(200,response.statusCode());


        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("roomNumber"));
        System.out.println("roomNumber = " + roomNumber);
        assertTrue(jsonPath.getList("roomNumber").contains(expectedData.getRoomNumber()));
        assertTrue(jsonPath.getList("roomType").contains(expectedData.getRoomType()));
        assertTrue(jsonPath.getList("status").contains(expectedData.getStatus()));
       // assertTrue(jsonPath.getList("price").contains(expectedData.getPrice()));
       // assertEquals(jsonPath.getList("price").get(0),expectedData.getPrice());
       // assertTrue(jsonPath.getList("price").contains(123.0));
        assertTrue(jsonPath.getList("description").contains(expectedData.getDescription()));

        //Data list dönüyor. O yüzden düzenleme olacaktır...
     /*
     sildirdi hoca bunu

        String actualRoomNumber = jsonPath.getString("findAll{it.roomNumber=="+roomNumber+"}.roomNumber");
        String actualRoomType = jsonPath.getString("findAll{it.roomNumber=="+roomNumber+"}.roomType");
        boolean actualStatus = jsonPath.getBoolean("findAll{it.roomNumber=="+roomNumber+"}.status");
        String actualPrice = jsonPath.getString("findAll{it.roomNumber=="+roomNumber+"}.price");
        String actualDescription = jsonPath.getString("findAll{it.roomNumber=="+roomNumber+"}.description");

        assertEquals(expectedData.getRoomNumber(), actualRoomNumber);
        assertEquals(expectedData.getRoomType(), actualRoomType);
        assertEquals(expectedData.getStatus(), actualStatus);
        assertEquals(expectedData.getPrice(), actualPrice);
        assertEquals(expectedData.getDescription(),actualDescription);
        Assert.assertEquals(200,response.statusCode());

*/
    /*
        List<String> actualRoomNumber1 = jsonPath.getList("findAll{it.roomNumber=="+roomNumber+"}.roomNumber");
        List<String> actualRoomType1 =  jsonPath.getList("findAll{it.roomNumber=="+roomNumber+"}.roomType");
        List<Boolean> actualStatus1 = jsonPath.getList("findAll{it.roomNumber=="+roomNumber+"}.status");
        List<Float>  actualPrice1 = jsonPath.getList("findAll{it.roomNumber=="+roomNumber+"}.price");
        List<String> actualDescription1 = jsonPath.getList("findAll{it.roomNumber=="+roomNumber+"}.description");
        Assert.assertEquals(expectedData.getRoomNumber(),actualRoomNumber1.get(0));
        Assert.assertEquals(expectedData.getRoomType(),actualRoomType1.get(0));
        Assert.assertEquals(expectedData.getStatus(),actualStatus1.get(0));
        Assert.assertEquals(expectedData.getPrice(),actualPrice1.get(0));
        Assert.assertEquals(expectedData.getDescription(),actualDescription1.get(0));

 */


    }

}

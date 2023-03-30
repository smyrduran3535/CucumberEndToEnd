package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {
    public static String generateToken(){
        Map<String ,Object> body=new HashMap<>();
        body.put("password", "Batch.103");
        body.put("rememberMe", true);
        body.put("username", "batch_yuzuc");
        Response response=given().contentType(ContentType.JSON).body(body).post("https://medunna.com/api/authenticate");//spec kullanmadıgımız icin content type belirtiyoruz
        //response.prettyPrint();
        return response.jsonPath().getString("id_token");
    }
    public static String sdgenerateToken(){
        Map<String ,Object> body=new HashMap<>();
        body.put("password", "tuba_hayati123");
        body.put("rememberMe", true);
        body.put("username", "tuba_hayati");
        Response response=given().contentType(ContentType.JSON).body(body).post("https://medunna.com/api/authenticate");//spec kullanmadıgımız icin content type belirtiyoruz
        //response.prettyPrint();
        return response.jsonPath().getString("id_token");
    }
}

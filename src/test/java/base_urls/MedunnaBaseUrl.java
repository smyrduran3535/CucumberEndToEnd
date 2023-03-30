package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utilities.AuthenticationMedunna.generateToken;
import static utilities.AuthenticationMedunna.sdgenerateToken;

public class MedunnaBaseUrl {
public static RequestSpecification spec;

    public static void medunnaSetUp(){
    spec=new RequestSpecBuilder().
            setContentType(ContentType.JSON).
            addHeader("Authorization", "Bearer "+generateToken())
            .setBaseUri("https://medunna.com").
            build();
}
    public static void sdmedunnaSetUp(){
        spec=new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization", "Bearer "+sdgenerateToken())
                .setBaseUri("https://medunna.com").
                build();
    }

}

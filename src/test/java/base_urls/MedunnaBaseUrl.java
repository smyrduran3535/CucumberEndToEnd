package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class MedunnaBaseUrl {
public static RequestSpecification spec;

    public static void medunnaSetUp(){
    spec=new RequestSpecBuilder().
            setContentType(ContentType.JSON).
            addHeader("Authorization", "Bearer "+"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaF95dXp1YyIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjgwMTE2NzM5fQ.EyMM9UtTczMdVq82ThRmRo27H90II94odFYNms4N7q6m_4xAQ9LUnww9UjsS2k8lMHVsCSf0a_UTgomGF2dVuw")
            .setBaseUri("https://medunna.com").
            build();
}

}

package praktikum.stellarburgers.constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Objects;

public class RestClient {
    protected static final String NO_ACCESS_TOKEN = null;
    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";

//    protected RequestSpecification getRequestSpecification() {
//        return new RequestSpecBuilder()
//                .setContentType(ContentType.JSON)
//                .setBaseUri(BASE_URL)
//                .build();
//    }
//
//    protected RequestSpecification getRequestAuthSpecification(String accessToken) {
//        return new RequestSpecBuilder()
//                .setContentType(ContentType.JSON)
//                .addHeader("authorization", accessToken)
//                .setBaseUri(BASE_URL)
//                .build();
//    }

    protected RequestSpecification getRequestSpecification(String accessToken) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL);

        requestSpecBuilder = Objects.equals(accessToken, null)
                ? requestSpecBuilder
                : requestSpecBuilder.addHeader("authorization", accessToken);

        return requestSpecBuilder.build();
    }

    protected RequestSpecification getRequestSpecification() {
        return getRequestSpecification(NO_ACCESS_TOKEN);
    }
}

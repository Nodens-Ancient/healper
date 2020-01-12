package framework.api;

import framework.enums.TypeOfConnection;
import framework.enums.TypesOfSort;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.interfaces.EmojInterface;

import java.util.Arrays;

public class JsonApi implements EmojInterface {
    private String url;
    private TypeOfConnection type = TypeOfConnection.GET;
    private RequestSpecification request = RestAssured.given();

    public JsonApi(String url) {
        this.url = url + KEY;
    }

    public Response executeRequest() {
        request.header("Content-Type", "application/json");
        switch (type) {
            case GET:
                return request.get(url);
            case POST:
                return request.post(url);
            default:
                EnumConstantNotPresentException enumConstantNotPresentException
                        = new EnumConstantNotPresentException(TypesOfSort.class, type.toString());
                throw enumConstantNotPresentException;
        }
    }


}


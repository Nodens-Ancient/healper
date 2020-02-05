package framework.api;

import framework.enums.TypeOfConnection;
import framework.enums.TypesOfSort;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.interfaces.EmojInterface;

public class JsonApi implements EmojInterface {
    private String url;
    private TypeOfConnection type = TypeOfConnection.GET;
    private RequestSpecification request = RestAssured.given();

    public JsonApi(String url) {
        this.url = url;
    }

    public Response executeRequest() {
        request.header("Content-Type", "application/json");
        switch (type) {
            case GET:
                Response response = request.get(url);
                System.out.println(url);
                System.out.println(response.asString());

                return response;
            case POST:
                return request.post(url);
            default:
                throw new EnumConstantNotPresentException(TypesOfSort.class, type.toString());
        }
    }


}


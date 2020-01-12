package framework.utils;

import api.market.enums.RequestEnums;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import framework.api.JsonApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.File;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ModelGenerator {
    public static <T> T getModelByMapping(File file, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(file, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoSuchElementException();
        }
    }

    public static <T> T getModelByMappingXml(File file, Class<T> clazz) {
        try {
            return new XmlMapper().readValue(file, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoSuchElementException();
        }
    }

    public static <T> T getModelByMapping(Response response, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(response.asByteArray(), clazz);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static <T> T getModelByMappingLink(String link, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(new JsonApi(link).executeRequest().asByteArray(), clazz);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static <T> T getModelByMappingWithKey(String link, String key, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(new JsonApi(link).executeRequest().asByteArray(), clazz);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static <T> T getModelByMappingWithKey(RequestEnums link, String key, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(new JsonApi(link + key).executeRequest().asByteArray(), clazz);
        } catch (Exception ignore) {
            return null;
        }
    }
}

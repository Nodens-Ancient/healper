package api.market;

import api.market.enums.RequestEnums;
import framework.api.JsonApi;
import framework.utils.ModelGenerator;
import models.apiModel.*;

public class RestApi {
    private String token;

    public RestApi(String token) {
        this.token = token;
    }

    public <T> T getResult(RequestEnums link, Class<T> clazz) {
        return ModelGenerator.getModelByMappingWithKey(link,token, clazz);
    }

    public void execute(RequestEnums link) {
        new JsonApi(link+token).executeRequest();
    }

    public String getLowestPrice(ItemFromInventoryModel item) {
        String url = String.format("https://market.csgo.com/api/BestSellOffer/%s_%s/?key=",
                item.getClassId(), item.getInstanceId());
        return new JsonApi(url + token).executeRequest().asString().replaceAll("[^\\d]", "");
    }

    public void setPrice(String params) {
        String[] paramsArr = params.split("\\|");
        String url = String.format("https://market.csgo.com/api/SetPrice/%s/%d/?key=",
                paramsArr[0], Integer.valueOf(paramsArr[1]) - 1);
        new JsonApi(url + token).executeRequest();
    }
}

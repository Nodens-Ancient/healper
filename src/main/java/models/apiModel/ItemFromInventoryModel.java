package models.apiModel;

import api.market.RestApi;
import bot.message.commands.CsGoMarket;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemFromInventoryModel {
    @JsonProperty("ui_id")
    private String ui_id;
    @JsonProperty("i_market_hash_name")
    private  String market_hash_name;
    @JsonProperty("i_market_name")
    private String market_name;
    @JsonProperty("i_name")
    private String name;
    @JsonProperty("i_classid")
    private String classId;
    @JsonProperty("i_instanceid")
    private String instanceId;
    private String price;

    public String updatePrice(CsGoMarket csGoMarket) {
        return csGoMarket.getPriceOfItem(this);
    }

    public boolean isStatTrack() {
        return market_hash_name.contains("StatTrak™");
    }


}


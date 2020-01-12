
package models.apiModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import models.interfaces.EmojInterface;

import javax.annotation.Generated;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemOnSell implements EmojInterface {

    @JsonProperty("ui_id")
    private String uiId;
    @JsonProperty("i_classid")
    private String cassid;
    @JsonProperty("i_instanceid")
    private String instanceid;
    @JsonProperty("i_market_hash_name")
    private String iMarketHashName;
    @JsonProperty("i_market_name")
    private String iMarketName;
    @JsonProperty("i_market_price")
    private Double iMarketPrice;
    @JsonProperty("i_market_price_text")
    private String iMarketPriceText;
    @JsonProperty("i_name")
    private String iName;
    @JsonProperty("i_name_color")
    private String iNameColor;
    @JsonProperty("ui_price")
    private Double uiPrice;
    @JsonProperty("ui_price_text")
    private String uiPriceText;
    @JsonProperty("ui_real_instance")
    private String uiRealInstance;
    @JsonProperty("ui_status")
    private int uiStatus;
    @JsonProperty("position")
    private int position;

    public String getStringUiStatus() {
        return String.format("%s %d", flagEmoji, getUiStatus());
    }
}

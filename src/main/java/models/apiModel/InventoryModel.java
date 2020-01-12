package models.apiModel;

import bot.message.commands.CsGoMarket;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryModel {

    private boolean ok;
    @JsonProperty("data")
    private ArrayList<ItemFromInventoryModel> items;

    public void updatePriceOfAllItems(CsGoMarket csGoMarket) {
        if (items!=null) {
            for (ItemFromInventoryModel item : items) {
                item.updatePrice(csGoMarket);
            }
        }
    }
}


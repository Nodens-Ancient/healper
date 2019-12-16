package models;

import api.market.RestApi;
import models.basemodel.Item;


public class InventoryItem extends Item {

    public  InventoryItem(String id){
        super(id, "https://market.csgo.com/api/GetInv/?key=");
    }

    public void sellItem() {
        new RestApi().setPrice(getId(), getPrice());
    }

    public String getPrice() {
        return new RestApi().getLowestPrice(getClassId(), getInstanceId());
    }
}

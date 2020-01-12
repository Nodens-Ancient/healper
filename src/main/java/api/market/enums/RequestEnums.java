package api.market.enums;

public enum RequestEnums {
    BALANCE("https://market.csgo.com/api/GetMoney/?key="),
    DELETE_ALL("https://market.csgo.com/api/RemoveAll/?key="),
    OFFLINE("https://market.csgo.com/api/GoOffline/?key="),
    ONLINE("https://market.csgo.com/api/PingPong/?key="),
    TRADE_STATUS("https://market.csgo.com/api/MarketTrades/?key="),
    ITEMS_ON_SALEE("https://market.csgo.com/api/Trades/?key="),
    INVENTORY("https://market.csgo.com/api/GetInv/?key="),
    CREATE_TRADE("https://market.csgo.com/api/ItemRequest/in/1/?key=");


    private String actions;

    RequestEnums(String link) {
        actions = link;
    }

    @Override
    public String toString() {
        return actions;
    }
}

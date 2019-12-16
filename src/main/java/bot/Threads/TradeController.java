package bot.Threads;

import api.market.RestApi;
import bot.Bot;
import lombok.SneakyThrows;
import models.interfaces.JsonParser;

public class TradeController extends Thread implements JsonParser {
    RestApi restApi = new RestApi();
    @SneakyThrows
    @Override
    public void run() {
        while(true){
            if (Boolean.valueOf(getParameter(restApi.getTradeStatus(), "success"))) {
                new Bot().sendMeMessage( "301289177", "\uD83D\uDC6F CHECK STEAM \uD83D\uDC6F");
            }
            sleep(10000);
        }
    }
}

package api.market.Threads;

import bot.Bot;
import bot.message.commands.CsGoMarket;
import lombok.SneakyThrows;
import models.apiModel.ItemOnSell;
import models.users.UserModel;
import subscribe.UserSubscribeControl;

import java.util.Arrays;

public class TradeController extends Thread {

    @SneakyThrows
    @Override
    public synchronized void run() {
        while (true) {
            for (UserModel user : UserSubscribeControl.getUsers()) {
                CsGoMarket csGoMarket = new CsGoMarket(user);
                ItemOnSell[] itemsOnSelle = csGoMarket.getIteemsOnSell();
                if (!(itemsOnSelle == null)) {
                    if (Arrays.stream(itemsOnSelle).anyMatch(item -> item.getUiStatus() == 2)) {
                        csGoMarket.createTradeOffer();
                        new Bot().sendMeMessage("301289177", "\uD83D\uDC6F CHECK STEAM \uD83D\uDC6F");
                    } else if (TradeControllerSingleton.switcher) {
                        csGoMarket.setOnline();
                    }
                }
                sleep(60000);
            }
        }
    }
}

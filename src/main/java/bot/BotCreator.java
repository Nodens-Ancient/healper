package bot;

import api.market.Threads.TradeControllerSingleton;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

class BotCreator {

    BotCreator() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            Bot bot = new Bot();
            telegramBotsApi.registerBot(bot);
            TradeControllerSingleton.startThread(bot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

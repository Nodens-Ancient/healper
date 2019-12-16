package bot;

import api.market.RestApi;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;


public class BotCreator {
    public BotCreator() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

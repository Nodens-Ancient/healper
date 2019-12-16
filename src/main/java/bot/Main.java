package bot;

import bot.Threads.TradeController;

public class Main {
    public static void main(String[] args) {
        new BotCreator();
        new TradeController().run();
    }
}

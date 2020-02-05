package api.market.Threads;

import bot.Bot;

public class TradeControllerSingleton {
    public static boolean switcher;
    private static TradeController controller;

    public static void startThread(Bot bot) {
        if (controller == null) {
            System.out.println("start");
            controller = new TradeController(bot);
            controller.start();
        }
    }
}

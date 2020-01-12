package api.market.Threads;

public class TradeControllerSingleton {
    public static boolean switcher;
    private static TradeController controller;

    public static void startThread() {
        if (controller == null) {
            System.out.println("start");
            controller = new TradeController();
            controller.start();
        }
    }
}

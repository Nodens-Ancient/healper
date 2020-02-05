package models.interfaces;

public interface EmojInterface {
    String emojiMoney = "\uD83E\uDD11";
    String emojiStateOnline = "\uD83C\uDF36";
    String emojiStateOffline = "\uD83D\uDCA4";
    String emojiSellAll = "\uD83D\uDCA5";
    String emojiDog = "\uD83D\uDC36";
    String emojiInventory = "\uD83D\uDDC4";
    String priceEmoji = "\uD83D\uDDE3";
    String stopEmoji = "\uD83D\uDEAB";
    String clearEmoji = "\uD83D\uDCA8";
    String doneEmoji = "\uD83D\uDC9A";
    String listEmoji = "\uD83D\uDCDC";
    String pinEmoji = "\uD83D\uDCCC";
    String flagEmoji = "\u26f3";

    static String getTextWithEmojieSurround(String text, String emoji) {
        return String.format("%s %s %s", emoji, text, emoji);
    }
}

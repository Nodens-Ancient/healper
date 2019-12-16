package bot.message.commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class Command {

    private Update update;
    public Command(Update update) {
        this.update = update;
    }

    public SendMessage getAnswer() {
        String message;
        if(update.hasCallbackQuery()){
            message = update.getCallbackQuery().getData();
            if(message.contains("SELL@")) {
                return new InterfaceStructure(update).getMessageOfSell(message
                        .replaceAll("SELL@", ""));
            }
            switch (message){
                case"BALANCE":
                    return  new InterfaceStructure(update).getBalanceMessage();
                case"TURN_OFF":
                    return new InterfaceStructure(update).getTurnedOffMessage();
                case"TURN_ON":
                    return new InterfaceStructure(update).getTurnedOnMessage();
                case"SELL_ITEM":
                    return new InterfaceStructure(update).getSellItemMenu();
                case"INVENTORY":
                    return new InterfaceStructure(update).getInventoryMessage();
                case"CLEAR_SELLING_LIST":
                    return new InterfaceStructure(update).getClearListMessage();
                default:
                    return new InterfaceStructure(update).getMainMenuKeyboard();
            }
        } else {
            return new InterfaceStructure(update).getMainMenuKeyboard();
        }
    }


}


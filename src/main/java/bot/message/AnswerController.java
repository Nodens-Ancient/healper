package bot.message;

import bot.message.commands.BotCommands;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Update;
import subscribe.UserSubscribeControl;

public class AnswerController extends BotCommands {
    private Update update;

    public AnswerController(Update update) {
        super(update);
        this.update = update;
    }

    public SendMessage getAnswer() {
        if (update.hasCallbackQuery()) {
            return answerCreator(update.getCallbackQuery());
        } else {
            if(UserSubscribeControl.getSubscribeStatusOfUser((update.getMessage().getChatId().toString()))) {
                return getMainMenuKeyboard();
            } else {
                return writeToAdmin();
            }
        }
    }

    private SendMessage answerCreator(CallbackQuery callbackQuery) {
        if(UserSubscribeControl.getSubscribeStatusOfUser((callbackQuery.getMessage().getChatId().toString()))) {
            String message = callbackQuery.getData();
            if (message.contains("SELL@")) {
                return getMessageOfSell(message.replaceAll("SELL@", ""));
            } else {
                switch (message){
                    case"BALANCE":
                        return  getBalanceMessage();
                    case"TURN_OFF":
                        return getTurnedOffMessage();
                    case"TURN_ON":
                        return getTurnedOnMessage();
                    case"SELL_ITEM":
                        return getSellItemMenu();
//                    case"INVENTORY":
//                        return getInventoryMessage();
                    case"SELL_LIST":
                        return  getListOfSells();
                    case"CLEAR_SELLING_LIST":
                        return getClearListMessage();
                    default:
                        return getMainMenuKeyboard();
                }
            }
        } else {
            return writeToAdmin();
        }
    }

//        private boolean isRegistered(String id) {
//            return ;
//    }
}


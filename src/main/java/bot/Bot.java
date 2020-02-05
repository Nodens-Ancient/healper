package bot;

import bot.message.AnswerController;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(new AnswerController(update).getAnswer());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "Ofgkta_bot";
    }

    @Override
    public String getBotToken() {
        return "831206675:AAEhe93MAkyW3xw2TBKIE08zKIhb4wDeJII";
    }

    public void sendMeMessage(String chatId, String message) {
        try {
            execute(new SendMessage().setChatId(chatId).setText(message));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

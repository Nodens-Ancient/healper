package bot;

import bot.message.commands.Command;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(new Command(update).getAnswer());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMeMessage(String chatId, String message) {
        try {
            execute(new SendMessage().setChatId(chatId).setText(message));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return System.getenv("name");
    }


    @Override
    public String getBotToken() {
        return  System.getenv("keyBot");
    }
}

package message.commands;

import bot.Buttons;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import java.io.IOException;

class InterfaceStructure {
    private Message message;
    InterfaceStructure(Message message) {
        this.message = message;
    }

    SendMessage getMainMenuKeyboard() {
        return getKeyboardBody().setReplyMarkup(new Buttons().getMainMenuKeyboard());

    }

    SendMessage getParcelKeyboard() throws IOException {
        return getKeyboardBody().setReplyMarkup(new Buttons().getParcelKeyboard());

    }

    SendMessage getRailwayKeyboard() {
        return getKeyboardBody().setReplyMarkup(new Buttons().getRailwayKeyboard());

    }

    private SendMessage getKeyboardBody(){
        return new SendMessage()
                .enableMarkdown(true)
                .setChatId(message.getChatId())
                .setText("take this");

    }
}

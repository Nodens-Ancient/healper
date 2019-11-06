package message;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import utils.PropertyController;

import java.io.IOException;

public class Request {

    Message message;
    Request(Message message) {
        this.message = message;
    }
    SendMessage getAnswer() throws IOException {
        return new SendMessage()
                .enableMarkdown(true)
                .setChatId(message.getChatId())
                .setText(PropertyController.getValueByKey(message.getText()));
    }
}

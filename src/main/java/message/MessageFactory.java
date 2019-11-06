package message;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import utils.PropertyController;

import java.io.IOException;

public class MessageFactory {
    private Message message;
    public MessageFactory(Message messageText){
        this.message = messageText;
    }
    public SendMessage getMessageType() throws IOException {
        if (PropertyController.getNames().contains(message.getText())) {
            return new Request(message).getAnswer();
        } else {
            return new Command(message).getAnswer();
        }
    }
}

package message;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import parcel.Parcel;
import utils.PropertyController;

import java.io.IOException;

public class Request {

    Message message;
    Request(Message message) {
        this.message = message;
    }

    SendMessage getAnswer() throws IOException {
        Parcel parcel = new Parcel();
        SendMessage result = new SendMessage()
                .enableMarkdown(true)
                .setChatId(message.getChatId())
                .setText(parcel.getParcelInfo(PropertyController.getValueByKey(message.getText())));
        parcel.closeBrowser();
        return result;

    }
}

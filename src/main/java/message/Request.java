package message;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import parcel.Parcel;
import railway.Railway;
import utils.PropertyController;

import java.io.IOException;

class Request {

    private Message message;
    Request(Message message) {
        this.message = message;
    }

    SendMessage getAnswerForRailway() {
        Railway railway = new Railway(message);
        SendMessage result = new SendMessage()
                .enableMarkdown(true)
                .setChatId(message.getChatId())
                .setText(railway.getTrainByTime());
        railway.closeBrowser();
        return result;
    }


    SendMessage getAnswerForParcel() throws IOException {
        Parcel parcel = new Parcel();
        SendMessage result = new SendMessage()
                .enableMarkdown(true)
                .setChatId(message.getChatId())
                .setText(parcel.getParcelInfo(PropertyController.getValueByKey(message.getText())));
        parcel.closeBrowser();
        return result;

    }
}

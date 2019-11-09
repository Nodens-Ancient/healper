package message;

import message.commands.Command;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import java.io.IOException;

public class MessageFactory {
    private Message message;
    public MessageFactory(Message message){
        this.message = message;
    }



    public SendMessage getMessageType() throws IOException {

        switch (message.getText()){
            case"menu": case"main menu": case"main":
            case"Menu": case"Main menu": case"Main":
            case"Parcels": case"RailWay": case"/parcels":
                return new Command(message).getAnswer();
            case "IN MIKHANOVICHI": case "IN MINSK":
                return new Request(message).getAnswerForRailway();
            default:
                return new Request(message).getAnswerForParcel();
        }
    }
}

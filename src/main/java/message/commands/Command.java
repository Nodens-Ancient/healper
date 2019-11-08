package message.commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import java.io.IOException;

public class Command {
    private Message message;

    public Command(Message message) {
        this.message = message;
    }

    public SendMessage getAnswer() throws IOException {
        String[] parts = message.getText().split("_");
        switch (parts[0]){
            case"/parcels":
                return new ParcelCommands(message).getAnswer();
            case"menu": case"main menu": case"main":
            case"Menu": case"Main menu": case"Main":
                return new InterfaceStructure(message).getMainMenuKeyboard();
            case"Parcels":
                return  new InterfaceStructure(message).getParcelKeyboard();
            case"RailWay":
                return new InterfaceStructure(message).getRailwayKeyboard();
            default:
                return new UnknownCommandExemption(message).sayToUser();
        }
    }

}


package message;

import bot.Buttons;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import utils.PropertyController;

import java.io.IOException;

public class Command {
    Message message;
    public Command(Message message) {
        this.message = message;
    }

    public SendMessage getAnswer() throws IOException {
        String[] commandParts = message.getText()
                .replaceAll("[/]", "")
                .split("_");
        switch (commandParts.length){
            case 2:
                if(commandParts[0].equals("rm")) {
                    PropertyController.deleteByKey(commandParts[1]);
                    return new SendMessage()
                            .enableMarkdown(true)
                            .setChatId(message.getChatId())
                            .setText("deleted").setReplyMarkup(new Buttons().setParcelButtons());
                }
            case 3:
                if(commandParts[0].equals("mv")) {
                    PropertyController.addKeyAndValue(commandParts[1], commandParts[2]);
                    return new SendMessage()
                            .enableMarkdown(true)
                            .setChatId(message.getChatId())
                            .setText("added").setReplyMarkup(new Buttons().setParcelButtons());

                }
            default:
                return new SendMessage()
                        .enableMarkdown(true)
                        .setChatId(message.getChatId())
                        .setText("nothing to do").setReplyMarkup(new Buttons().setParcelButtons());

        }
    }

}


package message.commands;

import bot.Buttons;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import utils.PropertyController;

import java.io.IOException;

class ParcelCommands {
    private Message message;
    ParcelCommands(Message message) {
        this.message = message;
    }


    SendMessage getAnswer() throws IOException {
        String[] commandParts = message.getText()
                .replaceAll("/parcels_", "")
                .split("_");
        switch (commandParts.length) {
            case 2:
                if (commandParts[0].equals("rm")) {
                    PropertyController.deleteByKey(commandParts[1]);
                    return new SendMessage()
                            .enableMarkdown(true)
                            .setChatId(message.getChatId())
                            .setText("deleted").setReplyMarkup(new Buttons().getParcelKeyboard());
                } else {
                    return null;
                }
            case 3:
                if (commandParts[0].equals("add")) {
                    PropertyController.addKeyAndValue(commandParts[1], commandParts[2]);
                    return new SendMessage()
                            .enableMarkdown(true)
                            .setChatId(message.getChatId())
                            .setText("added").setReplyMarkup(new Buttons().getParcelKeyboard());

                } else {
                    return null;
                }
            default:
                return new SendMessage()
                        .enableMarkdown(true)
                        .setChatId(message.getChatId())
                        .setText("nothing to do").setReplyMarkup(new Buttons().getParcelKeyboard());

        }
    }
}
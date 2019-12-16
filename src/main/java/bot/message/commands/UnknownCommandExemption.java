package bot.message.commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

class UnknownCommandExemption{
    private Message message;
    UnknownCommandExemption(Message message) {
        this.message = message;
    }

    SendMessage sayToUser(){
        return new SendMessage()
                .enableMarkdown(true)
                .setChatId(message.getChatId())
                .setText("bot.message.commands.UnknownCommandExemption");
    }

}

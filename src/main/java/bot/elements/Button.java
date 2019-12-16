package bot.elements;

import lombok.Data;
import models.interfaces.EmojInterface;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
@Data
public class Button implements EmojInterface {
    InlineKeyboardButton button;
    boolean switcher;

    public Button(String name, String action, String emojie) {
        button = new InlineKeyboardButton().setText(EmojInterface.getTextWithEmojieSurround(name, emojie))
                .setCallbackData(action);
    }

    public Button(String name, String action) {
        button = new InlineKeyboardButton().setText(name)
                .setCallbackData(action);
    }
}

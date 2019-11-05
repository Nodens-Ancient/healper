package bot;

import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import utils.PropertyController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Buttons {
    public ReplyKeyboardMarkup setParcelButtons() throws IOException {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        for (String name : PropertyController.getNames()) {
            KeyboardRow keyboardFirstRow = new KeyboardRow();
            keyboardFirstRow.add(new KeyboardButton(name));
            keyboard.add(keyboardFirstRow);
        }
        return replyKeyboardMarkup.setKeyboard(keyboard);
    }
}

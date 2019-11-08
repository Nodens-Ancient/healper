package bot;

import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import utils.PropertyController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Buttons {
    private ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    public Buttons(){
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

    }
    public ReplyKeyboardMarkup getMainMenuKeyboard() {
        return replyKeyboardMarkup.setKeyboard(createButtons(new String[]{"Parcels", "RailWay"}));
    }

    public ReplyKeyboardMarkup getRailwayKeyboard() {
        List<KeyboardRow> buttons = createButtons(new String[]{"В МИХАНОВИЧИ", "В МИНСК"});
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Main menu"));
        buttons.add(keyboardFirstRow);
        return replyKeyboardMarkup.setKeyboard(buttons);
    }

    private List<KeyboardRow> createButtons(Object[] set) {
        List<KeyboardRow> keyboard = new ArrayList<>();

        for (Object name : set) {
            KeyboardRow keyboardFirstRow = new KeyboardRow();
            keyboardFirstRow.add(new KeyboardButton((String) name));
            keyboard.add(keyboardFirstRow);
        }
        return keyboard;
    }

    public ReplyKeyboardMarkup getParcelKeyboard() throws IOException {
        List<KeyboardRow> buttons = createButtons(PropertyController.getNames().toArray());
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Main menu"));
        buttons.add(keyboardFirstRow);
        return replyKeyboardMarkup.setKeyboard(buttons);
    }
}

package bot.baseElements;

import bot.elements.Button;
import models.interfaces.EmojInterface;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BaseInterface implements EmojInterface {

    protected List<List<InlineKeyboardButton>> createButtons(Button[][] buttons) {
        List<List<InlineKeyboardButton>> rowList= new ArrayList<>();
        for (Button[] button : buttons) {
            List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
            for (Button btn : button) {
                keyboardButtonsRow1.add(btn.getButton());
            }
            rowList.add(keyboardButtonsRow1);
        }
        return rowList;
    }

    protected List<List<InlineKeyboardButton>> createButtons(ArrayList<Button> buttons) {
        List<List<InlineKeyboardButton>> rowList= new ArrayList<>();
        for (Button button : buttons) {
            List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();

            keyboardButtonsRow1.add(button.getButton());

            rowList.add(keyboardButtonsRow1);
        }
        return rowList;
    }


//    KeyboardRow keyboardFirstRow = new KeyboardRow();
//            new KeyboardButton((String) name)
//            keyboardFirstRow.add();
//            keyboard.add(keyboardFirstRow);

}

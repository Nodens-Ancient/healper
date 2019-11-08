package railway;

import browser.Browser;
import org.telegram.telegrambots.api.objects.Message;
import railway.pageobject.PoezdatoPage;

public class Railway {

    private PoezdatoPage poezdatoPage;

    public Railway(Message message) {
        poezdatoPage = new PoezdatoPage(new Browser().getBrowser(), message.getText());
    }

    public String getTrainByTime() {
        return poezdatoPage.getNearestTrain();
    }
    public void closeBrowser() {
        poezdatoPage.closeDriver();
    }

}
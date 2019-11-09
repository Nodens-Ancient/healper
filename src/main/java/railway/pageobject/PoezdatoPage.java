package railway.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PoezdatoPage {
    private WebDriver driver;
    private String stream;
    private static String date = new SimpleDateFormat("dd.MM.yyyy/HH:mm")
            .format(Calendar.getInstance().getTime());
    public PoezdatoPage(WebDriver driver, String stream) {
        this.driver = driver;
        this.stream = stream;
    }
    public void closeDriver() {
        this.driver.close();
    }

    private String generateLink() {
        if (stream.equals("IN MIKHANOVICHI")){
            return  "http://poezdato.net/raspisanie-poezdov/minsk--mihanovichi/"
                    + date.replaceAll("/.+", "/");
        } else {
            return "http://poezdato.net/raspisanie-poezdov/mihanovichiminsk--minsk/"
                    + date.replaceAll("/.+", "/");
        }
    }

    public String getNearestTrain(){
        driver.get(generateLink());
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"even\"]"));
        String result = "error";
        for (WebElement element : elements) {
            String[] line = element.getText()
                    .replaceAll("\n", " ").split(" ");
            int trainTime = Integer.parseInt(line[4].replaceAll("\\.", ""));
            int timeNow = Integer.parseInt(date.replaceAll(".+/", "")
                    .replaceAll(":", ""));
            if (trainTime > timeNow ) {

                return  (line[1] + " " + line[2] + " " + line[3]
                        + "\nОтправление: " + line[4]
                        + "\nПрибытие: " + line[6]);}
        }
        System.out.println(result);
        return result;
    }

}

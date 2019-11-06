package parcel.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ErrorHandler;

public class ParcelPage {
    WebDriver driver;
    public ParcelPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://webservices.belpost.by/searchRu.aspx");
    }


    private void enterTheCodeOfParcel(String codeOfParcel) {
        driver.findElement(By.xpath("//*[@id=\"TxtNumPos\"]")).sendKeys(codeOfParcel);
        driver.findElement(By.id("BtnSearch")).click();
    }

    private String parseResult(String codeOfParcel) {
        String text;
        try {
            enterTheCodeOfParcel(codeOfParcel);
            text = driver.findElement(By.xpath("//*[@id=\"GridInfo0\"]/tbody"))
                    .getText();
        } catch (Exception e) {
            return "По данному отправлению ничего не найдено";
        }

        System.out.println(text);
        String[] linesOfResult = text
                .split("\n");
        return linesOfResult[linesOfResult.length - 1];
    }

    public void closeDriver() {
        this.driver.close();
    }

    public String getInfoByCode(String codeOfParcel) {
        return parseResult(codeOfParcel);
    }
}
//(\d+\.)+[\d]+ date

//        stringBuilder.append(driver.findElement(By.xpath("//*[contains(@id,'GridInfo')]")).getText());
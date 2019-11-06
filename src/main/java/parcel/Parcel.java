package parcel;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import parcel.pageobject.ParcelPage;

public class Parcel {
    WebDriver driver;
    ParcelPage parcelPage;
    public Parcel() {
        driver = new Browser().getBrowser();
        parcelPage = new ParcelPage(driver);
    }

    public String getParcelInfo(String codeOfParcel) {
        return parcelPage.getInfoByCode(codeOfParcel);
    }
    public void closeBrowser() {
        parcelPage.closeDriver();
    }
}

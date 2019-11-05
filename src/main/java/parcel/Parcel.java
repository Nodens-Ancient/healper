package parcel;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import parcel.pageobject.ParcelPage;

public class Parcel {
    WebDriver driver;

    public Parcel() {
        driver = new Browser().getBrowser();
    }

    public String getParcelInfo(String codeOfParcel) {
        return new ParcelPage(driver).getInfoByCode(codeOfParcel);
    }
}

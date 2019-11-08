package parcel;

import browser.Browser;
import parcel.pageobject.ParcelPage;

public class Parcel {
    private ParcelPage parcelPage;
    public Parcel() {
        parcelPage = new ParcelPage(
                new Browser("https://webservices.belpost.by/searchRu.aspx")
                        .getBrowser());
    }

    public String getParcelInfo(String codeOfParcel) {
        return parcelPage.getInfoByCode(codeOfParcel);
    }
    public void closeBrowser() {
        parcelPage.closeDriver();
    }
}

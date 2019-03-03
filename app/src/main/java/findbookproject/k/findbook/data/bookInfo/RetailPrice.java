package findbookproject.k.findbook.data.bookInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetailPrice {
    @SerializedName("amount")
    @Expose
    public Double amount;
    @SerializedName("currencyCode")
    @Expose
    public String currencyCode;

    public Double getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}

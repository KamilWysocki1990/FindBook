package findbookproject.k.findbook.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Epub {

    @SerializedName("isAvailable")
    @Expose
    public Boolean isAvailable;

}
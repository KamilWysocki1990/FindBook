package findbookproject.k.findbook.data.bookInfo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Pdf {
    @SerializedName("isAvailable")
    @Expose
    public Boolean isAvailable;

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    @SerializedName("acsTokenLink")
    @Expose
    public String acsTokenLink;


}

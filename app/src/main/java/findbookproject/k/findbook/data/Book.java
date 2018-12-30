package findbookproject.k.findbook.data;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("totalItems")
    TotalBookAnserws totalBookAnserws;
    public String id;

    public TotalBookAnserws getTotalBookAnserws() {
        return totalBookAnserws;
    }

    public String getId() {
        return id;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public String selfLink;
    public VolumeInfo volumeInfo;


}

package findbookproject.k.findbook.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//@SerializedName("items")
public class Items {


    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("etag")
    @Expose
    public String etag;
    @SerializedName("selfLink")
    @Expose
    public String selfLink;
    @SerializedName("volumeInfo")
    @Expose
    public VolumeInfo volumeInfo;
    @SerializedName("saleInfo")
    @Expose
    public SaleInfo saleInfo;
    @SerializedName("accessInfo")
    @Expose
    public AccessInfo accessInfo;

}

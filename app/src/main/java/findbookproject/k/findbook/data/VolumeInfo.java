package findbookproject.k.findbook.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class VolumeInfo {


    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("authors")
    @Expose
    public List<String> authors = null;
    @SerializedName("publisher")
    @Expose
    public String publisher;
    @SerializedName("publishedDate")
    @Expose
    public String publishedDate;
    @SerializedName("readingModes")
    @Expose
    public ReadingModes readingModes;
    @SerializedName("pageCount")
    @Expose
    public Integer pageCount;
    @SerializedName("printType")
    @Expose
    public String printType;
    @SerializedName("maturityRating")
    @Expose
    public String maturityRating;
    @SerializedName("allowAnonLogging")
    @Expose
    public Boolean allowAnonLogging;
    @SerializedName("contentVersion")
    @Expose
    public String contentVersion;
    @SerializedName("imageLinks")
    @Expose
    public ImageLinks imageLinks;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("previewLink")
    @Expose
    public String previewLink;
    @SerializedName("infoLink")
    @Expose
    public String infoLink;
    @SerializedName("canonicalVolumeLink")
    @Expose
    public String canonicalVolumeLink;

}

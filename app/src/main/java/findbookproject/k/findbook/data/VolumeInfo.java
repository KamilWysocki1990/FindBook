package findbookproject.k.findbook.data;

import java.util.ArrayList;
import java.util.List;

public class VolumeInfo {


   public String title;
   public List<String> authors = new ArrayList<>();
    public  String publisher;
    public String publishedDate;
    public int pageCount;

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public String getCanonicalVolumneLink() {
        return canonicalVolumneLink;
    }

    public String maturityRating;
    public String language;
    public String previewLink;
    public  String infoLink;
    public  String canonicalVolumneLink;


}

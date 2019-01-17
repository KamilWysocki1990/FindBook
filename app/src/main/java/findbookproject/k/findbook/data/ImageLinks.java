package findbookproject.k.findbook.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import findbookproject.k.findbook.R;

public class ImageLinks {

    @SerializedName("smallThumbnail")
    @Expose
    public String smallThumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;

    public String getImageBook() {
        if (!thumbnail.isEmpty()) {
            return thumbnail;

        } else {
            return "R.mipmap.detective_search";
    }


    }
}

package findbookproject.k.findbook.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReadingModes {

        @SerializedName("text")
        @Expose
        public Boolean text;
        @SerializedName("image")
        @Expose
        public Boolean image;

}

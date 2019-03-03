package findbookproject.k.findbook.data.bookInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBooks {

   public List<Items> getItems() {
      return items;
   }

   public void setItems(List<Items> items) {
      this.items = items;
   }

   @SerializedName("items")
   @Expose
   private List<Items> items = null;


}

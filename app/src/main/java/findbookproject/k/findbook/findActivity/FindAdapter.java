package findbookproject.k.findbook.findActivity;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import findbookproject.k.findbook.R;
import findbookproject.k.findbook.data.Items;

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.ViewHolder> {

    private List<Items> books = new ArrayList<>();

    public void updateBooks(List<Items> bookList){
        books.clear();
        books.addAll(bookList);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anserw,parent,false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.setup(books.get(position));
    }


    @Override
    public int getItemCount() {
        return books.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_book_image)
        ImageView bookImage;

        @BindView(R.id.item_anserw_description)
        TextView bookDescription;

        @BindView(R.id.item_anserw_name)
        TextView bookName;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void setup(Items item){
            if(item.volumeInfo.imageLinks == null){
                bookImage.setImageResource(R.mipmap.detective_search);
            } else {
                Glide.with(itemView.getContext())
                        .load(item.getVolumeInfo().getImageLinks().thumbnail)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                Toast.makeText(itemView.getContext(), "failed", Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                Toast.makeText(itemView.getContext(), "Load Complete", Toast.LENGTH_LONG).show();

                                return false;
                            }
                        })
                        .into(bookImage)
                ;
            }

            bookDescription.setText(item.volumeInfo.description);
            bookName.setText(item.volumeInfo.title + item.volumeInfo.authors.get(0));


        }


    }
}

package findbookproject.k.findbook.activitys.bookHistory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import findbookproject.k.findbook.R;
import findbookproject.k.findbook.activitys.chosenBookActivity.ChosenBookActivity;
import findbookproject.k.findbook.activitys.findActivity.FindActivityContract;
import findbookproject.k.findbook.activitys.findActivity.FindAdapter;
import findbookproject.k.findbook.data.bookInfo.Items;
import findbookproject.k.findbook.data.watchedBook.WatchedBook;

class HistoryBookAdapter extends RecyclerView<BookHistoryAdapter.BookHolder> {



    private List<Items> books = new ArrayList<>();


    public void updateBooks(List<Items> bookList) {
        books.clear();
        books.addAll(bookList);
        notifyDataSetChanged();


    }


    @NonNull
    @Override
    public FindAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FindAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_anserw, parent, false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull FindAdapter.ViewHolder holder, int position) {
        holder.setup(books.get(position));
    }


    @Override
    public int getItemCount() {
        return books.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_book_image)
        ImageView bookImage;

        @BindView(R.id.item_anserw_description)
        TextView bookDescription;

        @BindView(R.id.item_anserw_name)
        TextView bookName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        void setup(Items item) {

            bookDescription.setText(item.getVolumeInfo().getDescription());
            itemView.setOnClickListener(view -> {

                        Bundle selectedBookData = new Bundle();
                        Intent intent = new Intent(itemView.getContext(), ChosenBookActivity.class);
                        intent.putExtras(selectedBookData);

                        itemView.getContext().startActivity(intent);

                    }
            );


        }







    }



}

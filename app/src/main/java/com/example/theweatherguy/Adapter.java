package com.example.theweatherguy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<RecyclerViewItem> arrayListOfItems;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageViewCompat;
        public TextView textViewCompat1;
        public TextView textViewCompat2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCompat = itemView.findViewById(R.id.list_item_animation);
            textViewCompat1 = itemView.findViewById(R.id.list_item_title);
            textViewCompat2 = itemView.findViewById(R.id.list_item_subtitle);

        }
    }

    public Adapter(ArrayList<RecyclerViewItem> listOfDays) {
        arrayListOfItems = listOfDays;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                parent, false);
        ViewHolder vHolder = new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RecyclerViewItem currentItem = arrayListOfItems.get(position);

        holder.imageViewCompat.setImageResource(currentItem.getImageResource());
        holder.textViewCompat1.setText(currentItem.getText1());
        holder.textViewCompat2.setText(currentItem.getText2());

    }


    @Override
    public int getItemCount() {

        return arrayListOfItems.size();
    }
}

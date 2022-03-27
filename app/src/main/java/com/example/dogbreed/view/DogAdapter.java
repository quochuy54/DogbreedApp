package com.example.dogbreed.view;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogbreed.R;
import com.example.dogbreed.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder>{
    private List<DogBreed> dogBreeds;

    public DogAdapter(List<DogBreed> dogBreeds) {
        this.dogBreeds = dogBreeds;
    }

    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dogitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {
        holder.name.setText(dogBreeds.get(position).getName());
        holder.description.setText(dogBreeds.get(position).getTemperament());
        Picasso.get().load(dogBreeds.get(position).getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView name;
            private ImageView img;
            private TextView description;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textname);
            img = view.findViewById(R.id.image);
            description = view.findViewById(R.id.description);
        }
    }
}

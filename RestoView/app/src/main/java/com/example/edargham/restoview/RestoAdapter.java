package com.example.edargham.restoview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.RestoViewHolder> {

    List<Container> restorants;
    Context context;

    public RestoAdapter(Context con, List<Container> restos) {
        restorants = restos;
        context = con;
    }


    @Override
    public RestoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new RestoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestoViewHolder holder, int position) {
        Container resto = restorants.get(position);
        holder.name.setText(resto.getRestaurant().getName());
        holder.cuisine.setText(resto.getRestaurant().getCuisine());
        holder.rating.setText(resto.getRestaurant().getUser_rating().getAverage_rating());
        holder.ratingText.setText(resto.getRestaurant().getUser_rating().getRating_text());

    }

    @Override
    public int getItemCount() {
        return restorants.size();
    }

    public class RestoViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView cuisine;
        TextView rating;
        TextView ratingText;

        public RestoViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name);
            cuisine = view.findViewById(R.id.cuisine);
            rating = view.findViewById(R.id.rating);
            ratingText = view.findViewById(R.id.textrate);
        }
    }
}

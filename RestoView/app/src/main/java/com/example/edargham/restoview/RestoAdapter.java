package com.example.edargham.restoview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edargham.restoview.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.RestoViewHolder> {

    List<Container> restorants;
    Context context;
    OnItemClickListener icl;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public RestoAdapter(Context con, List<Container> restos) {
        restorants = restos;
        context = con;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
            icl = listener;
    }


    @Override
    public RestoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new RestoViewHolder(view, icl);
    }

    @Override
    public void onBindViewHolder(RestoViewHolder holder, int position) {
        Container resto = restorants.get(position);
        holder.name.setText(resto.getRestaurant().getName());
        holder.cuisine.setText(resto.getRestaurant().getCuisine());
        holder.rating.setText(resto.getRestaurant().getUser_rating().getAverage_rating());
        holder.ratingText.setText(resto.getRestaurant().getUser_rating().getRating_text());
        Picasso
                .with(context)
                .load(resto.getRestaurant().getImgUrl())
                .transform(new CircleTransform())
                .into(holder.imgView);

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
        ImageView imgView;

        public RestoViewHolder(View view, final OnItemClickListener listen){
            super(view);
            name = view.findViewById(R.id.name);
            cuisine = view.findViewById(R.id.cuisine);
            rating = view.findViewById(R.id.rating);
            ratingText = view.findViewById(R.id.textrate);
            imgView  = view.findViewById(R.id.restoicon);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listen != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listen.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

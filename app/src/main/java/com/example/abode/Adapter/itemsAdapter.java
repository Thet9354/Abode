package com.example.abode.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.abode.Details_Activity;
import com.example.abode.Model.ItemsDomain;
import com.example.abode.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.ViewHolder> {

    ArrayList<ItemsDomain> itemsDomainArrayList;
    DecimalFormat formatter;
    Context context;

    public itemsAdapter(ArrayList<ItemsDomain> itemsDomainArrayList) {
        this.itemsDomainArrayList = itemsDomainArrayList;
        formatter = new DecimalFormat("###,###,###,###,##");
    }

    @NonNull
    @Override
    public itemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull itemsAdapter.ViewHolder holder, int position) {

        holder.txtView_title.setText(itemsDomainArrayList.get(position).getTitle());
        holder.txtView_address.setText(itemsDomainArrayList.get(position).getAddress());
        holder.txtView_price.setText("$" + formatter.format(itemsDomainArrayList.get(position).getPrice()));

        int drawableResourceId = holder.itemView.getResources().getIdentifier(itemsDomainArrayList.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.imgView_estate);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details_Activity.class);
                intent.putExtra("object", itemsDomainArrayList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsDomainArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private androidx.cardview.widget.CardView cv_estate;
        private ImageView imgView_estate;
        private TextView txtView_title, txtView_address, txtView_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //CardView
            cv_estate = itemView.findViewById(R.id.cv_estate);

            //ImageView
            imgView_estate = itemView.findViewById(R.id.imgView_estate);

            //TextView
            txtView_title = itemView.findViewById(R.id.txtView_title);
            txtView_address = itemView.findViewById(R.id.txtView_address);
            txtView_price = itemView.findViewById(R.id.txtView_price);

        }
    }
}

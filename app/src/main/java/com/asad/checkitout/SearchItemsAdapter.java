package com.asad.checkitout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchItemsAdapter extends RecyclerView.Adapter<SearchItemsAdapter.MyViewHolder> implements Filterable
{
    private List<GridProductModel> gridProductModelList;
    private List<GridProductModel> gridProductModelListCopy;
    private Context context;
    private LayoutInflater inflater;

    public SearchItemsAdapter(Context context, List<GridProductModel> gridProductModelList) {
        this.context = context;
        this.gridProductModelList = gridProductModelList;
        gridProductModelListCopy = new ArrayList<>(gridProductModelList);
        inflater = (LayoutInflater.from(context));
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // set the data in items

        holder.productName.setText(gridProductModelList.get(position).getProductName());
        holder.productPrice.setText(gridProductModelList.get(position).getProductPrice());
        holder.productImage.setImageResource(gridProductModelList.get(position).getProductImage());
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, gridProductModelList.get(position).getProductImage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return gridProductModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productName;// init the item view's
        TextView productPrice;
        ImageView productImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            productName = (TextView) itemView.findViewById(R.id.textView_product_name);
            productPrice = (TextView) itemView.findViewById(R.id.grid_product_price_textview);
            productImage = (ImageView) itemView.findViewById(R.id.grid_product_image);
        }
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    private Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<GridProductModel> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(gridProductModelListCopy);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(GridProductModel item : gridProductModelListCopy){
                    if(item.getProductName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            gridProductModelList.clear();
            gridProductModelList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}

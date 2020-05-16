package com.asad.checkitout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
    private List<CartModel> cartModelList;

    public CartAdapter(List<CartModel> cartModelList) {
        this.cartModelList = cartModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartModelList.get(position).getType()) {
            case 0:
                return CartModel.CART_ITEM;
            case 1:
                return CartModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case CartModel.CART_ITEM:
                View cartItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);
                return new CartItemViewHolder(cartItemView);
            case CartModel.TOTAL_AMOUNT:
                View totalAmountView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_price_layout, parent, false);
                return new TotalAmountViewHolder(totalAmountView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartModelList.get(position).getType()) {
            case CartModel.CART_ITEM:
                int image = cartModelList.get(position).getProductImage();
                String name = cartModelList.get(position).getProductName();
                String price = cartModelList.get(position).getProductPrice();
                String size = cartModelList.get(position).getProductSize();
                String quantity = cartModelList.get(position).getProductQuantity();
                ((CartItemViewHolder) holder).setCartItemDetails(image,name,price,size,quantity);
                break;
            case CartModel.TOTAL_AMOUNT:
                String totalItems = cartModelList.get(position).getTotalItems();
                String totalItemsPrice = cartModelList.get(position).getTotalItemsPrice();
                String deliveryCharges = cartModelList.get(position).getDeliveryCharges();
                String totalPrice = cartModelList.get(position).getTotalPrice();
                ((TotalAmountViewHolder)holder).setTotalAmountDetails(totalItems,totalItemsPrice,deliveryCharges,totalPrice);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;
        private TextView productSize;
        private ElegantNumberButton productQuantity;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.imageView_image_cart_item);
            productTitle = itemView.findViewById(R.id.textView_name_cart_item);
            productPrice = itemView.findViewById(R.id.textView_price_cart_item);
            productSize = itemView.findViewById(R.id.textView_Size_cart_item);
            productQuantity = (ElegantNumberButton) itemView.findViewById(R.id.quantity_cart_item);
        }

        private void setCartItemDetails(int image, String name, String price, String size, String quantity) {
            productImage.setImageResource(image);
            productTitle.setText(name);
            productPrice.setText(price);
            productSize.setText(size);
            productQuantity.setNumber(quantity);
        }
    }

    class TotalAmountViewHolder extends RecyclerView.ViewHolder {

        private TextView totalItems;
        private TextView totalItemsPrice;
        private TextView deliveryCharges;
        private TextView totalPrice;

        public TotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItems = (TextView) itemView.findViewById(R.id.textView_sub_total_item_price_text);
            totalItemsPrice = (TextView) itemView.findViewById(R.id.textView_sub_total_item_price);
            deliveryCharges = (TextView) itemView.findViewById(R.id.textView_deliveryCharges);
            totalPrice = (TextView) itemView.findViewById(R.id.textView_total_item_price);
        }

        private void setTotalAmountDetails(String total_items, String total_items_price, String delivery_charges, String total_price) {
            totalItems.setText(total_items);
            totalItemsPrice.setText(total_items_price);
            deliveryCharges.setText(delivery_charges);
            totalPrice.setText(total_price);
        }
    }
}

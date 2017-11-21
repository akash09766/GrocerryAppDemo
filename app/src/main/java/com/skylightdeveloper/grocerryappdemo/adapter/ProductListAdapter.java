package com.skylightdeveloper.grocerryappdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.skylightdeveloper.grocerryappdemo.R;
import com.skylightdeveloper.grocerryappdemo.interfaces.OnItemClickListener;
import com.skylightdeveloper.grocerryappdemo.model.ItemData;

import java.util.ArrayList;

/**
 * Created by akash.wangalwar on 21/11/17.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ItemData> list;
    private OnItemClickListener onItemClickListener;


    public ProductListAdapter(Context context, ArrayList<ItemData> list, OnItemClickListener onItemClickListener) {

        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.product_item_list_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {

        ItemData item = list.get(position);

        holder.mProdName.setText(item.getItemName());
        holder.mProductCount.setText(item.getCount()+"");

        holder.mIncrementCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.itemClick(position, true);
            }
        });

        holder.mDecrementCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.itemClick(position, false);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        private TextView mProdName, mProductCount;
        private Button mIncrementCount, mDecrementCount;

        public ProductViewHolder(View itemView) {
            super(itemView);

            mProdName = itemView.findViewById(R.id.prod_name_tv_id);
            mProductCount = itemView.findViewById(R.id.count_tv_id);

            mIncrementCount = itemView.findViewById(R.id.plus_btn_id);
            mDecrementCount = itemView.findViewById(R.id.minus_btn_id);

        }
    }
}

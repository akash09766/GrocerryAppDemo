package com.skylightdeveloper.grocerryappdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.skylightdeveloper.grocerryappdemo.R;
import com.skylightdeveloper.grocerryappdemo.adapter.ProductListAdapter;
import com.skylightdeveloper.grocerryappdemo.interfaces.OnItemClickListener;
import com.skylightdeveloper.grocerryappdemo.model.ItemData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView mProductLv;

    private ArrayList<ItemData> mListData = new ArrayList<>();

    private ProductListAdapter adapter;
    private TextView mTotalprodCount;
    private Button mProceedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setIdsToViews();

        CreateDataForAdapter();

        setDataToAdapter();
    }

    private void setDataToAdapter() {

        adapter = new ProductListAdapter(this, mListData, this);
        mProductLv.setAdapter(adapter);
    }

    private void CreateDataForAdapter() {
        for (int i = 0; i < 10; i++) {
            mListData.add(new ItemData("Rexona item " + i));
        }
    }

    private void setIdsToViews() {

        mProductLv = (RecyclerView) findViewById(R.id.product_lv_id);
        mTotalprodCount = (TextView) findViewById(R.id.prod_count_tv_id);
        mProceedBtn = (Button) findViewById(R.id.proceed_btn_id);
        mProductLv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void itemClick(int postion, boolean isInCrement) {


        if (isInCrement) {

            mListData.get(postion).setCount(mListData.get(postion).getCount() + 1);

        } else {

            if(mListData.get(postion).getCount() == 0){
                return;
            }
            mListData.get(postion).setCount(mListData.get(postion).getCount() - 1);

        }

        int totalCount = 0;

        for (ItemData item : mListData) {

            totalCount = totalCount + item.getCount();
        }

        mTotalprodCount.setText("product count "+totalCount);

        adapter.notifyDataSetChanged();

        if(totalCount == 0){
            mProceedBtn.setEnabled(false);
        }else {
            mProceedBtn.setEnabled(true);
        }
    }
}

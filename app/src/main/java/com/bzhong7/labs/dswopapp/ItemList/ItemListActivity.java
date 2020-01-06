package com.bzhong7.labs.dswopapp.ItemList;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.bzhong7.labs.dswopapp.R;
import com.bzhong7.labs.dswopapp.Utils.TopNavigationViewHelper;

import java.util.LinkedList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 4;

    private RecyclerView mItemRecycler;
    private ItemListAdapter itemListAdapter;

    Context mContext = ItemListActivity.this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        setupTopNavigationView();

        ItemCards item1 = new ItemCards("Leather Bag", "High quality bag made from real leather. Like new.", 5, "Jack");

        List<ItemCards> itemList = new LinkedList<ItemCards>();

        itemList.add(item1);

        mItemRecycler = (RecyclerView) findViewById(R.id.reyclerview_item_list);

        itemListAdapter = new ItemListAdapter(mContext, itemList);
        mItemRecycler.setLayoutManager(new LinearLayoutManager(this));
        mItemRecycler.setAdapter(itemListAdapter);
    }

    private void setupTopNavigationView() {
        //Log.d(TAG, "setupTopNavigationView: setting up TopNavigationView");
        BottomNavigationViewEx tvEx = findViewById(R.id.topNavViewBar);
        TopNavigationViewHelper.setupTopNavigationView(tvEx);
        TopNavigationViewHelper.enableNavigation(mContext, tvEx);
        Menu menu = tvEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}

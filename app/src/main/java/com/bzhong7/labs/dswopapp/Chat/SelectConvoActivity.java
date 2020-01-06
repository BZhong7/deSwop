package com.bzhong7.labs.dswopapp.Chat;

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

public class SelectConvoActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 2;

    private RecyclerView mConvoRecycler;
    private ConvoListAdapter convoListAdapter;

    Context mContext = SelectConvoActivity.this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_conversation);
        setupTopNavigationView();

        BaseMessage message1 = new BaseMessage("Were the items traded successfully?", "System", "15:40", 4);
        List<BaseMessage> convoList = new LinkedList<BaseMessage>();
        convoList.add(message1);

        mConvoRecycler = (RecyclerView) findViewById(R.id.reyclerview_convo_list);

        convoListAdapter = new ConvoListAdapter(this, convoList);
        mConvoRecycler.setLayoutManager(new LinearLayoutManager(this));
        mConvoRecycler.setAdapter(convoListAdapter);
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

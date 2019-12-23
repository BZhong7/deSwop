package com.quintus.labs.datingapp.Chat;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Utils.TopNavigationViewHelper;

import java.util.LinkedList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 2;

    private RecyclerView mMessageRecycler;
    private MessageListAdapter messageListAdapter;

    Context mContext = ChatActivity.this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        setupTopNavigationView();

        BaseMessage message1 = new BaseMessage("Test Offer", "John Doe", "14:25", 0);
        BaseMessage message2 = new BaseMessage();
        BaseMessage message3 = new BaseMessage("Hello hello", "Jack", "14:30", 1);
        List<BaseMessage> messageList = new LinkedList<BaseMessage>();
        messageList.add(message1);
        messageList.add(message2);
        messageList.add(message3);

        mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);

        messageListAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(messageListAdapter);
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

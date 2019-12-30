package com.quintus.labs.datingapp.Chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quintus.labs.datingapp.R;

import java.util.LinkedList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter messageListAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        ImageButton btnBackArrow = findViewById(R.id.btn_back_arrow);
        btnBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, SelectConvoActivity.class);
                startActivity(intent);
            }
        });

        BaseMessage message1 = new BaseMessage("Suggested Offer", "John Doe", "14:25", 0);
        BaseMessage message2 = new BaseMessage("How about it? My sneakers for your bag?", "John Doe", "14:25", 2);
        BaseMessage message3 = new BaseMessage("Sounds good to me! Let's trade", "Jack", "14:30", 1);
        BaseMessage message4 = new BaseMessage("John Doe has accepted your offer", "System", "14:33", 3);
        BaseMessage message5 = new BaseMessage("Were the items traded successfully?", "System", "15:40", 4);

        List<BaseMessage> messageList = new LinkedList<BaseMessage>();

        messageList.add(message1);
        messageList.add(message2);
        messageList.add(message3);
        messageList.add(message4);
        messageList.add(message5);

        mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);

        messageListAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(messageListAdapter);
    }
}

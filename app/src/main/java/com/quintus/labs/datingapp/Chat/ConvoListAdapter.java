package com.quintus.labs.datingapp.Chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.quintus.labs.datingapp.R;

import java.util.List;

public class ConvoListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<BaseMessage> mConvoList;

    public ConvoListAdapter(Context context, List<BaseMessage> convoList) {
        mContext = context;
        mConvoList = convoList;
    }

    @Override
    public int getItemCount() { return mConvoList.size(); }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_convo, parent, false);
        return new ItemConvoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseMessage message = mConvoList.get(position);

        ((ItemConvoHolder) holder).bind(message);
    }

    private class ItemConvoHolder extends RecyclerView.ViewHolder {
        TextView username, messageText, timeText;
        Button btnSelectConvo;

        ItemConvoHolder (View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.text_username);
            messageText = itemView.findViewById(R.id.text_recent_message);
            timeText = itemView.findViewById(R.id.text_date);
            btnSelectConvo = itemView.findViewById(R.id.btn_choose_convo);
        }
        void bind(BaseMessage message) {
            username.setText("John Doe");
            messageText.setText(message.getMessage());
            timeText.setText(message.getSentAt());

            btnSelectConvo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ChatActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}

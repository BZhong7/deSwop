package com.bzhong7.labs.dswopapp.Chat;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bzhong7.labs.dswopapp.Main.EthNetwork;
import com.bzhong7.labs.dswopapp.R;

import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_SUGGESTED_OFFER = 0;
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    private static final int VIEW_TYPE_MESSAGE_SYSTEM = 3;
    private static final int VIEW_TYPE_TRADE_CONFIRMATION = 4;

    private Context mContext;
    private List<BaseMessage> mMessageList;

    private EthNetwork contract = new EthNetwork();

    public MessageListAdapter(Context context, List<BaseMessage> messageList) {
        mContext = context;
        mMessageList = messageList;
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    // Determines the appropriate ViewType according to the sender of the message.
    @Override
    public int getItemViewType(int position) {
        int messageType = mMessageList.get(position).getId();

        if (messageType == 0) {
            //If the message is for making an offer
            return VIEW_TYPE_SUGGESTED_OFFER;
        } else if (messageType == 1) {
            // If the user sent the message
            return VIEW_TYPE_MESSAGE_SENT;
        } else if (messageType == 2) {
            //If some other user sent the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        } else if (messageType == 3) {
            //If the message is from neither user
            return VIEW_TYPE_MESSAGE_SYSTEM;
        } else {
            return VIEW_TYPE_TRADE_CONFIRMATION;
        }
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_received, parent, false);
            return new ReceivedMessageHolder(view);
        } else if (viewType == VIEW_TYPE_SUGGESTED_OFFER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_suggested_offer, parent, false);
            return new SuggestedOfferHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_SYSTEM) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_system, parent, false);
            return new SystemMessageHolder(view);
        } else if (viewType == VIEW_TYPE_TRADE_CONFIRMATION) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_trade_confirmation, parent, false);
            return new TradeConfirmationHolder(view);
        }

        return null;
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseMessage message = mMessageList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_SUGGESTED_OFFER:
                ((SuggestedOfferHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_SYSTEM:
                ((SystemMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_TRADE_CONFIRMATION:
                ((TradeConfirmationHolder) holder).bind(message);
        }
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
        }

        void bind(BaseMessage message) {
            messageText.setText(message.getMessage());
            timeText.setText(message.getSentAt());
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText, nameText;
        ImageView profileImage;

        ReceivedMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
            nameText = (TextView) itemView.findViewById(R.id.text_message_name);
            profileImage = (ImageView) itemView.findViewById(R.id.image_message_profile);
        }

        void bind(BaseMessage message) {
         messageText.setText(message.getMessage());
         timeText.setText(message.getSentAt());
         nameText.setText(message.getSender());
         //Uri imgUri = Uri.parse("file:///home/brandon/deSwop/app/src/main/res/drawable/monkey.png");
         //profileImage.setImageURI(imgUri);
        }
    }

    private class SuggestedOfferHolder extends RecyclerView.ViewHolder {
        TextView suggestedOfferText, userWantsText;

        SuggestedOfferHolder(View itemView) {
            super(itemView);

            userWantsText = (TextView) itemView.findViewById(R.id.user_wants_text);
            suggestedOfferText = (TextView) itemView.findViewById(R.id.suggested_offer_text);
        }
        void bind(BaseMessage message) {
            userWantsText.setText(message.getSender() + " wants to trade:");
            suggestedOfferText.setText(message.getMessage());
        }
    }

    private class SystemMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        SystemMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
        }
        void bind(BaseMessage message) {
            messageText.setText(message.getMessage());
            timeText.setText(message.getSentAt());
        }
    }

    private class TradeConfirmationHolder extends RecyclerView.ViewHolder {
        Button btnYes, btnNo;

        TradeConfirmationHolder(View itemView) {
            super(itemView);

            btnYes = itemView.findViewById(R.id.btn_trade_success);
            btnNo = itemView.findViewById(R.id.btn_trade_fail);
        }
        void bind(BaseMessage message) {

            //Print system message and generate Non-Fungible Token.
            btnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnYes.setEnabled(false);
                    btnNo.setEnabled(false);

                    GetTransactionHash txHash = new GetTransactionHash();
                    txHash.execute();
                }
            });

            btnNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseMessage sysMessage = new BaseMessage("Trade has failed.", "System", "16:00", 3);
                    mMessageList.add(sysMessage);

                    notifyDataSetChanged();

                    btnYes.setEnabled(false);
                    btnNo.setEnabled(false);
                }
            });
        }
    }

    //Waits for block to be added to blockchain before obtaining Transaction Hash.
    private class GetTransactionHash extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            BaseMessage sysMessage1 = new BaseMessage("Trade confirmed successful.", "System", "16:00", 3);
            BaseMessage sysMessage2 = new BaseMessage("Please wait for transaction hash...", "System", "16:00", 3);

            contract.execute();

            mMessageList.add(sysMessage1);
            mMessageList.add(sysMessage2);
            notifyDataSetChanged();
        }

        protected String doInBackground(Void... params) {
            String txHash = "";
            try {
                txHash = contract.getTxHash();
            } catch (Exception e) {
                System.err.println("Error1: Unable to obtain Transaction Hash");
            }
            return txHash;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s != "") {
                BaseMessage hashMessage = new BaseMessage("Transaction Hash: " + s, "System", "16:01", 3);
                mMessageList.add(hashMessage);
            } else {
                BaseMessage errMessage = new BaseMessage("Failed to obtain transaction hash", "System", "16:01", 3);
                mMessageList.add(errMessage);
            }
            notifyDataSetChanged();
        }
    }
}

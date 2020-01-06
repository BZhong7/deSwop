package com.bzhong7.labs.dswopapp.ItemList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bzhong7.labs.dswopapp.R;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<ItemCards> mItemList;

    public ItemListAdapter(Context context, List<ItemCards> itemList) {
        mContext = context;
        mItemList = itemList;
    }

    @Override
    public int getItemCount() { return mItemList.size(); }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new ItemListAdapter.ItemListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemCards item = mItemList.get(position);

        ((ItemListAdapter.ItemListHolder) holder).bind(item);
    }

    private class ItemListHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView itemImage;
        Button btnSelectItem;

        ItemListHolder (View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.text_item_name);
            itemImage = itemView.findViewById(R.id.image_item);
            btnSelectItem = itemView.findViewById(R.id.btn_select_item);
        }
        void bind(ItemCards item) {
            itemName.setText(item.getItemName());

            btnSelectItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ItemInfoActivity.class);
                    intent.putExtra("itemName", item.getItemName());
                    intent.putExtra("itemDescription", item.getItemDescription());
                    intent.putExtra("itemCategory", item.getItemCategory());
                    intent.putExtra("itemOwner", item.getItemOwner());
                    context.startActivity(intent);
                }
            });
        }
    }
}

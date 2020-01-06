package com.bzhong7.labs.dswopapp.ItemList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bzhong7.labs.dswopapp.R;

public class ItemInfoActivity extends AppCompatActivity {

    private Context mContext = ItemInfoActivity.this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        TextView itemName = findViewById(R.id.item_name);
        TextView itemDescription = findViewById(R.id.item_description);

        Intent intent = getIntent();
        itemName.setText(intent.getStringExtra("itemName"));
        itemDescription.setText(intent.getStringExtra("itemDescription"));

        Spinner spinner = findViewById(R.id.categorySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(intent.getIntExtra("itemCategory", 1));
    }
}

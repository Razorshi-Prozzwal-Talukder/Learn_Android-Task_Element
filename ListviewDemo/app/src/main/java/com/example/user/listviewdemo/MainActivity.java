package com.example.user.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        //at first, get all item name from string array
        final String[] contactNames = getResources().getStringArray(R.array.contact_names);

        //make adapter: use array adapter for only  item <data type> = (from which class, data from which layout, textid, string name)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.item_view, R.id.textViewId, contactNames);
        //show all item in view by using adapter(arrayadapter-> single list adapter)
        listView.setAdapter(adapter);

        //item listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String value = contactNames[i]; //which item is selected
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

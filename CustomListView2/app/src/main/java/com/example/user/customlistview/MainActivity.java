package com.example.user.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] contactNames;
    //photo are set by their index
    int[] image = {R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_person_black_24dp,R.drawable.ic_person_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            listView = findViewById(R.id.listViewId);
            contactNames = getResources().getStringArray(R.array.contact_names);

            //Custom adapter er kaj holo resourse theke file gulo nie view e convert kora
            CustomAdapter customAdapter = new CustomAdapter(this, contactNames, image);
            listView.setAdapter(customAdapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String value = contactNames[i]; //which item is selected
                    Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                }
            });
    }
}

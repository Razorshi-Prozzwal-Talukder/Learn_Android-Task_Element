package com.example.user.floatingbutton;

import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For Custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);

        //For Floating Action Menu
        FabSpeedDial fabSpeedDial = findViewById(R.id.fabSpeedDial);

        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;//false: don't show menu
            }
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Toast.makeText(MainActivity.this,""+menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
            @Override
            public void onMenuClosed() {

            }
        });//end floating action menu
    }

    //For making Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }
    //OptionMenu gula tik moto kaj korano
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "Item 3 Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subItem1:
                Toast.makeText(this, "Subitem 1 Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subItem2:
                Toast.makeText(this, "Subitem 2 Selected", Toast.LENGTH_SHORT).show();
                return true;

                default:
                    return super.onOptionsItemSelected(item);

        }
    }//Option menu tik moto kaj korano ekhanei sesh
}

package com.example.user.collups_fragment_mixed;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For Custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);


        //Fragment Set korar jonno

        tabLayout = findViewById(R.id.tabLayoutId);
        appBarLayout = findViewById(R.id.appBarId);
        viewPager = findViewById(R.id.viewPagerId);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding FragmentName
        adapter.AddFragment(new FragmentShare(),"Share");
        adapter.AddFragment(new FragmentHistory(),"History");
        adapter.AddFragment(new FragmentFavourite(),"Fav");

        //Adapter Step
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

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

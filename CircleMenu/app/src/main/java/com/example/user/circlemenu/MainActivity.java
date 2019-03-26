package com.example.user.circlemenu;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {

    String arrayName[] = {"Facebook",
                           "Twitter",
                            "Android",
                            "Quora",
                            "Wikipidia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.plus, R.drawable.remove1)
                .addSubMenu(Color.parseColor("#258CFF"),R.drawable.facebook)
                .addSubMenu(Color.parseColor("#EF496E"),R.drawable.twitter)
                .addSubMenu(Color.parseColor("#F2F515"),R.drawable.android)
                .addSubMenu(Color.parseColor("#38E226"),R.drawable.quora)
                .addSubMenu(Color.parseColor("#97ADB4"),R.drawable.wordpress)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if(index==0){
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com"));
                            startActivity(intent);
                        }
                        if(index==1){
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/"));
                            startActivity(intent);
                        }
                        if(index==2){
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://developer.android.com/studio/intro"));
                            startActivity(intent);
                        }
                        if(index==3){
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.quora.com/"));
                            startActivity(intent);
                        }
                        if(index==4){
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.wikipedia.org/"));
                            startActivity(intent);
                        }

//                        Toast.makeText(MainActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();

                    }
                });
    }
}

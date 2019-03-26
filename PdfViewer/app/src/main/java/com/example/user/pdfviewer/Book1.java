package com.example.user.pdfviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book1 extends AppCompatActivity {

    PDFView book1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);

        book1 = findViewById(R.id.pdfBook1);

        //now calling method
        book1.fromAsset("head first design patterns - ora 2004.pdf").load();
    }
}

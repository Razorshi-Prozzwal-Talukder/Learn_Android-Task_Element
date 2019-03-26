package com.example.user.pdf_viewer_from_storage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

public class ViewActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        pdfView = findViewById(R.id.pdf_viewer);

        if(getIntent() != null)
        {
            String viewType = getIntent().getStringExtra("ViewType");
            if(viewType != null || !TextUtils.isEmpty(viewType))
            {
                if(viewType.equals("assets"))
                {
                    pdfView.fromAsset("The Clean Coder.pdf")
                            .password(null)//if have password
                    .defaultPage(0) //open default page , you can remember this value to open from last time
                    .enableSwipe(true)
                            .swipeHorizontal(false)
                            .enableDoubletap(true)//DoubleTap for zoom
                    .onDraw(new OnDrawListener() {
                        @Override
                        public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                            //code if you want to do something
                        }
                    })
                            .onDrawAll(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                    //code if you wanna something to do
                                }
                            })
                            .onPageError(new OnPageErrorListener() {
                                @Override
                                public void onPageError(int page, Throwable t) {
                                    Toast.makeText(ViewActivity.this, "Error While Open Page"+page, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .onPageChange(new OnPageChangeListener() {
                                @Override
                                public void onPageChanged(int page, int pageCount) {
                                    //code here if u want to do something
                                }
                            })
                            .onTap(new OnTapListener() {
                                @Override
                                public boolean onTap(MotionEvent e) {
                                    return true;
                                }
                            })
                            .onRender(new OnRenderListener() {
                                @Override
                                public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                    pdfView.fitToWidth();//fixed screen size
                                }
                            })
                            .enableAnnotationRendering(true)
                            .invalidPageColor(Color.WHITE)
                            .load();

                }

                else if (viewType.equals("storage"))
                {
                    Uri pdfFile = Uri.parse(getIntent().getStringExtra("FileUri"));

                    pdfView.fromUri(pdfFile)
                            .password(null)//if have password
                            .defaultPage(0) //open default page , you can remember this value to open from last time
                            .enableSwipe(true)
                            .swipeHorizontal(false)
                            .enableDoubletap(true)//DoubleTap for zoom
                            .onDraw(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                    //code if you want to do something
                                }
                            })
                            .onDrawAll(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                    //code if you wanna something to do
                                }
                            })
                            .onPageError(new OnPageErrorListener() {
                                @Override
                                public void onPageError(int page, Throwable t) {
                                    Toast.makeText(ViewActivity.this, "Error While Open Page"+page, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .onPageChange(new OnPageChangeListener() {
                                @Override
                                public void onPageChanged(int page, int pageCount) {
                                    //code here if u want to do something
                                }
                            })
                            .onTap(new OnTapListener() {
                                @Override
                                public boolean onTap(MotionEvent e) {
                                    return true;
                                }
                            })
                            .onRender(new OnRenderListener() {
                                @Override
                                public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                    pdfView.fitToWidth();//fixed screen size
                                }
                            })
                            .enableAnnotationRendering(true)
                            .invalidPageColor(Color.WHITE)
                            .load();

                }
            }
        }
    }
}

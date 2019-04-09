package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class SecondActivity extends AppCompatActivity {

    private Integer images[] = {R.drawable.castello,R.drawable.crisantemo,R.drawable.deserto,R.drawable.koala,R.drawable.medusa,R.drawable.pinguini,R.drawable.tulipano};
    private int numofimages = images.length;
    private int currentImage = 1;
    boolean isImageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsuccesfull);

        setInitialImage();
        setImageRotateListener();
        //Log.d("Find Me", "Main Funzione");
    }

    private void setImageRotateListener() {
        final Button rotatebutton = (Button)findViewById(R.id.btnRotateImage);
        //Log.d("Find Me", "DOVEEEE Funzione");
        rotatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currentImage++;
                if (currentImage == numofimages) {
                    currentImage = 0;
                }
                setCurrentImage();
            }
        });
    }

    private void setInitialImage() {
        setCurrentImage();
        //Log.d("Find Me", "Initial Funzione");
    }

    private void setCurrentImage() {
        //Log.d("Find Me", "Current Funzione");
        final ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        imageView.setImageResource(images[currentImage]);

        //Codice per aprire l'immagine a full screen
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isImageFitToScreen) {
                    isImageFitToScreen=false;
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    imageView.setAdjustViewBounds(true);
                }else{
                    isImageFitToScreen=true;
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
        });


        final Button rotatebutton = (Button)findViewById(R.id.btnRotateImage);
        //Log.d("Find Me", "DOVEEEE Funzione");
        rotatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImage++;
                if (currentImage == numofimages) {
                    currentImage = 0;
                }
                setCurrentImage();
            }
        });
    }

}

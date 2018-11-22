package com.example.lab505b.imagecam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgFav = (ImageView)findViewById(R.id.imageview);

        imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });

    }
    //with onClick in xml
    //public void open(View v){

    //Without onclick :
    public void open(){


        //to launch an existing camera application installed on the mobile
        //ACTION_VIDEO_CAPTURE
        //IT calls the existing video application in android to capture video
        //INTENT_ACTION_VIDEO_CAMERA
        //this intent is used to launch the camera in video mode

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode ,int resultCode ,Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imgFav.setImageBitmap(bp);

    }

}
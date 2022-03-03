package com.example.camerra2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button button;
    ImageView imageview;
    Bitmap bitmap;
    View view;
    ByteArrayOutputStream bytearrayoutputstream;
    File file;
    FileOutputStream fileoutputstream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button1);
        imageview = (ImageView)findViewById(R.id.imageView1);
        bytearrayoutputstream = new ByteArrayOutputStream();

        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub


                Drawable drawable = getResources().getDrawable(R.drawable.froyo_circle);

                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

                bitmap.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);

                file = new File( Environment.getExternalStorageDirectory() + "/SampleImage.png");

                try

                {
                    file.createNewFile();

                    fileoutputstream = new FileOutputStream(file);

                    fileoutputstream.write(bytearrayoutputstream.toByteArray());

                    fileoutputstream.close();

                }

                catch (Exception e)

                {

                    e.printStackTrace();

                }

                Toast.makeText(MainActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

            }
        });
    }

}
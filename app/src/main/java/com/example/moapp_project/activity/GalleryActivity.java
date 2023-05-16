package com.example.moapp_project.activity;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moapp_project.R;
import com.example.moapp_project.adapter.GalleryAdapter;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final int numberOfColume=3;

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //layoutManager=new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColume));

        mAdapter=new GalleryAdapter(this, getImagePath(this));
        recyclerView.setAdapter(mAdapter);
    }

    public static ArrayList<String> getImagePath(Activity activity){
        Uri uri;
        ArrayList<String> listOfAllImage=new ArrayList<String>();
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        String PathOfImage=null;
        uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection={MediaStore.MediaColumns.DATA,
                    MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        cursor=activity.getContentResolver().query(uri,projection,
                null,null,null);

        column_index_data=cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name=cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while(cursor.moveToNext()){
            PathOfImage=cursor.getString(column_index_data);

            listOfAllImage.add(PathOfImage);
        }
        return listOfAllImage;
    }

}

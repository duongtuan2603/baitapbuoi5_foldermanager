package com.example.baitapbuoi5_foldermanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Folder> folders = new ArrayList<Folder>();
    FolderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        folders.add(new Folder("Video"));
        folders.add(new Folder("Android"));
        folders.add(new Folder("Applock"));
        folders.add(new Folder("Books"));
        folders.add(new Folder("Maps"));
        folders.add(new Folder("Authentication"));
        adapter = new FolderAdapter(folders,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.btnaddfolder)
        {folders.add(new Folder("Recently added folder"));adapter.notifyDataSetChanged();}
        return super.onOptionsItemSelected(item);
    }
}
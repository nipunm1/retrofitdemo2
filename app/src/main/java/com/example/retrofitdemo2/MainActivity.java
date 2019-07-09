package com.example.retrofitdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofitdemo2.adapter.MyRecyclerAdapter;
import com.example.retrofitdemo2.api.RetroFitClient;
import com.example.retrofitdemo2.model.MyGit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//TextView textView;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.text);
        recyclerView = findViewById(R.id.recyclerview);
        getMyGitAccount();
    }
    private void getMyGitAccount(){
        RetroFitClient.api.getMyGit("nipunm1").enqueue(new Callback<List<MyGit>>() {
            @Override
            public void onResponse(Call<List<MyGit>> call, Response<List<MyGit>> response) {
                List<MyGit>list =response.body();
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(MainActivity.this, list);
                recyclerView.setAdapter(myRecyclerAdapter);
                //Log.d("list", list+"");
                //textView.setText(list+"");

            }

            @Override
            public void onFailure(Call<List<MyGit>> call, Throwable t) {
                //Log.d("error : ", t.getMessage());
                //textView.setText(t.getMessage());
            }
        });
    }
}

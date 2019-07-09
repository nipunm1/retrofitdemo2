package com.example.retrofitdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo2.adapter.MyRecyclerAdapter;
import com.example.retrofitdemo2.api.RetroFitClient;
import com.example.retrofitdemo2.model.MyGit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView textView,textView2;
ImageView imageView;
//RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        imageView = findViewById(R.id.image);
        //recyclerView = findViewById(R.id.recyclerview);
        //getMyGitAccount();
        getMyGitAccount2();
    }
    /*private void getMyGitAccount(){
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
    }*/
    private void getMyGitAccount2(){
        RetroFitClient.api.getMyGit2("nipunm1").enqueue(new Callback<MyGit>() {
            @Override
            public void onResponse(Call<MyGit> call, Response<MyGit> response) {
                //Log.d("response", response.toString());
                MyGit myGit = response.body();
                String name = myGit.getLogin();
                int id = myGit.getId();
                textView.setText(name);
                textView2.setText(id+"");
                Glide.with(MainActivity.this).load(myGit.getAvatarUrl()).into(imageView);

                //textView.setText(response.toString());
            }

            @Override
            public void onFailure(Call<MyGit> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });
    }
}

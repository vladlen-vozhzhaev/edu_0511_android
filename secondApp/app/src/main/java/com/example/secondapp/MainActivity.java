package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;
    Button addUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addUser = findViewById(R.id.addUser);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        recyclerViewInit();
        Log.d("SYSTEM INFO: ", "Метод onResume() запущен");
    }

    private void recyclerViewInit(){
        Users users = Users.get(MainActivity.this);
        List<String> userList = users.getUserList();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }


    // UserHolder отвечает за каждый элемент списко по отдельности
    // Именно здесь мы будем наполнчть нашу activity_item контентом
    private class UserHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.activity_item,viewGroup,false));
            //itemView - текущий layout activity_item
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        public void bind(String userName){
            itemTextView.setText(userName);
        }
    }
    // UserAdapter нужен для того, чтобы разместить элементы на RecyclerView
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        List<String> userList;
        public UserAdapter(List<String> userList) {
            this.userList = userList;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            // inflater - наполнитель
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            String userName = userList.get(position);
            userHolder.bind(userName);
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO: ", "Метод onStart() запущен");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Метод onSaveInstanceState() запущен");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO: ", "Метод onPause() запущен");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO: ", "Метод onStop() запущен");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO: ", "Метод onDestroy() запущен");
    }
}
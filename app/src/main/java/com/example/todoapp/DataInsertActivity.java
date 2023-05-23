package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.todoapp.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
    ActivityDataInsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String type  = getIntent().getStringExtra("type");
        if(type.equals("update")){
            setTitle("Update");
            binding.titleET.setText(getIntent().getStringExtra("title"));
            binding.noteET.setText(getIntent().getStringExtra("note"));
            int id = getIntent().getIntExtra("id", 0);
            binding.addBtn.setText("update note");
            binding.addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.titleET.getText().toString());
                    intent.putExtra("note", binding.noteET.getText().toString());
                    intent.putExtra("id", id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }else{
            setTitle("Add Mode");
            binding.addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.titleET.getText().toString());
                    intent.putExtra("note", binding.noteET.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this, MainActivity.class));
    }
}
package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.databinding.TodoItemBinding;

public class RVAdapter extends ListAdapter<Note, RVAdapter.MyViewHolder> {
    public RVAdapter(){
        super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getSubTitle());
        }
    };

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = getItem(position);
        holder.binding.titleTV.setText(note.getTitle());
        holder.binding.subTitle.setText(note.getSubTitle());
    }

    public Note getNote(int position){
        return getItem(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TodoItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = TodoItemBinding.bind(itemView);
        }
    }
}

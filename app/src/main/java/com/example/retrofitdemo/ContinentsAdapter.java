package com.example.retrofitdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.apitestmodel.BaseDataClass;
import com.example.retrofitdemo.apitestmodel.ObjectDataClass;
import com.example.retrofitdemo.databinding.ContinentalRowBinding;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsAdapter.ViewHolder> {
    private List<ObjectDataClass> objectDataClasses;


    public void updateBaseData(List<ObjectDataClass> objectDataClasses){
        this.objectDataClasses = objectDataClasses;
    }

    @NonNull
    @Override
    public ContinentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContinentalRowBinding rowBinding = ContinentalRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new ViewHolder(rowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentsAdapter.ViewHolder holder, int position) {
        ObjectDataClass objectData = objectDataClasses.get(position);
        holder.bindView(objectData);
    }

    @Override
    public int getItemCount() {
        return objectDataClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ContinentalRowBinding rowBinding;
        public ViewHolder(@NonNull ContinentalRowBinding rowBinding) {
            super(rowBinding.getRoot());
            this.rowBinding = rowBinding;
        }

        public void bindView(ObjectDataClass objectData) {
            rowBinding.setRow(objectData);
        }
    }
}

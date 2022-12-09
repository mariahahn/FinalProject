package com.example.finalproject4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//Maria Santos - Final Project
public class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.MyViewHolder> {

    private Context context;
    private List<ElementsModel> data;

    public ElementsAdapter(Context context, List<ElementsModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ElementsAdapter.MyViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.elements_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementsAdapter.MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.symbol.setText(data.get(position).getSymbol());
        holder.number.setText(data.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView symbol;
        TextView number;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_name);
            symbol = itemView.findViewById(R.id.textView_symbol);
            number  = itemView.findViewById(R.id.textView_number);
        }
    }
}

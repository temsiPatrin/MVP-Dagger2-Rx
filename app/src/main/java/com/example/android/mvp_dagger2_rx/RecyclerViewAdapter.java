package com.example.android.mvp_dagger2_rx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mvp_dagger2_rx.pojo.CryptoData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<CryptoData> data;
    private RecyclerViewAdapter.ClickListener clickListener;

    @Inject
    public RecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCoin.setText(data.get(position).symbol);
        holder.txtCurrentPrice.setText(data.get(position).priceUsd);
        holder.txt1HourChange.setText(data.get(position).percentChange1h + "%");
        holder.txt24HourChange.setText(data.get(position).percentChange24h + "%");
        holder.txt7DayChange.setText(data.get(position).percentChange7d + "%");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCoin;
        private TextView txtCurrentPrice;
        private TextView txt1HourChange;
        private TextView txt24HourChange;
        private TextView txt7DayChange;
        private ConstraintLayout constraintLayoutContainer;

        ViewHolder(View itemView) {
            super(itemView);

            txtCoin = itemView.findViewById(R.id.txtCoin);
            txtCurrentPrice = itemView.findViewById(R.id.txtCurrentPrice);
            txt1HourChange = itemView.findViewById(R.id.txtOneHourChange);
            txt24HourChange = itemView.findViewById(R.id.txt24HourChange);
            txt7DayChange = itemView.findViewById(R.id.txt7DayChange);
            constraintLayoutContainer = itemView.findViewById(R.id.constraintLayout);

            constraintLayoutContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.launchIntent(data.get(getAdapterPosition()).name);
                }
            });
        }
    }
    public interface ClickListener {
        void launchIntent(String name);
    }
    public void setData(List<CryptoData> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}

package com.puan.looptestdev.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.puan.looptestdev.R;
import com.puan.looptestdev.entity.Device;

import java.util.ArrayList;
import java.util.List;

public class BleAdapter extends RecyclerView.Adapter<BleAdapter.ViewHolder>{
    private List<Device> devices = new ArrayList<Device>();

    @Override
    public BleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ble, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BleAdapter.ViewHolder holder, int position) {
        Device device = devices.get(position);
        holder.bleName.setText(device.getBleMac() + "--" + device.getBleName());
    }

    public BleAdapter(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bleName;
        private View view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }
    }
}

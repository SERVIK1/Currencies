package ru.raspgleb.currenciesoftheworld;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends BaseAdapter {
    private Context context;
    private List<Currency> currencyList;

    // Конструктор с инициализацией
    public CurrencyAdapter(Context context, List<Currency> currencyList){
        this.context = context;
        this.currencyList = currencyList;
    }

    @Override
    public int getCount() {
        return currencyList != null ? currencyList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_flag, parent, false);
        TextView txt_name = rootView.findViewById(R.id.name);
        ImageView image_flag = rootView.findViewById(R.id.image_flag);
        txt_name.setText(currencyList.get(position).getName());
        image_flag.setImageResource(currencyList.get(position).getImage());
        return rootView;
    }
}

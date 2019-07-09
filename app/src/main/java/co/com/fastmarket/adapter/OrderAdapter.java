package co.com.fastmarket.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.fastmarket.R;
import co.com.fastmarket.modelo.Order;

public class OrderAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Order> orders;

    public OrderAdapter(Context context, ArrayList<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(context, R.layout.list_orders, null);
        }

        TextView amountTv = view.findViewById(R.id.amountTv);
        Order order = orders.get(i);

        amountTv.setText(String.valueOf(order.getOrderAmount()));

        return view;
    }
}

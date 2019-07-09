package co.com.fastmarket.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.fastmarket.R;
import co.com.fastmarket.controlador.Product.OnItemClickListener;
import co.com.fastmarket.modelo.Product;

public class ProductAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Product> products;

    private final OnItemClickListener listener;

    public ProductAdapter(Context context, ArrayList<Product> products, OnItemClickListener listener) {
        this.context = context;
        this.products = products;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = View.inflate(context, R.layout.list_items, null);
        }

        ImageButton imageButton = view.findViewById(R.id.imBtnBuy);
        ImageView images = view.findViewById(R.id.productImage);
        TextView productName = view.findViewById(R.id.productNameTv);
        TextView productDesc = view.findViewById(R.id.productDescTv);
        TextView productAmount = view.findViewById(R.id.productAmount);
        Product product = products.get(i);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(products.get(i));
            }
        });

        images.setImageResource(product.getImageId());
        productName.setText(product.getProductName());
        productDesc.setText(product.getProductDescription());
        productAmount.setText(String.valueOf(product.getProductAmount()));

        return view;
    }
}

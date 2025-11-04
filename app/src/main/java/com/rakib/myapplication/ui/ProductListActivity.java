package com.rakib.myapplication.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rakib.myapplication.R;
import com.rakib.myapplication.dbUtil.ProductAdapter;
import com.rakib.myapplication.dbUtil.ProductUtil;
import com.rakib.myapplication.entity.Product;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ProductAdapter adapter;
    private ProductUtil productUtil;

    private FloatingActionButton fabAdd;

    private List<Product> productList;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);

        recyclerView = findViewById(R.id.recyclerView);
        fabAdd = findViewById(R.id.fabAdd);
        productUtil = new ProductUtil(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(ProductListActivity.this, ProductAddActivity.class);
            startActivity(intent);
        });

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }


    private void loadProducts(){
        productList = productUtil.getAllProducts();
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {

        super.onResume();
        loadProducts();

    }
}
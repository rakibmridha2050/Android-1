package com.rakib.myapplication.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.rakib.myapplication.R;
import com.rakib.myapplication.dbUtil.ProductUtil;
import com.rakib.myapplication.entity.Product;

public class ProductAddActivity extends AppCompatActivity {

    private EditText edtName,edtEmail, edtPrice,edtQuantity;
    private Button btnSave;

    private ProductUtil productUtil;

    private Product product;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_add);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPrice = findViewById(R.id.edtPrice);
        edtQuantity = findViewById(R.id.edtQuantity);
        btnSave = findViewById(R.id.btnSave);

        productUtil = new ProductUtil(this);

        // ✅ Button click listener
        btnSave.setOnClickListener(v -> {

            // Get user input
            String name = edtName.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String price = edtPrice.getText().toString().trim();
            String quantity = edtQuantity.getText().toString().trim();

            // Simple validation
            if (name.isEmpty() || email.isEmpty() || price.isEmpty() || quantity.isEmpty()) {
                Toast.makeText(ProductAddActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create message for dialog
            String message = "📦 Product Details:\n\n"
                    + "Name: " + name + "\n"
                    + "Email: " + email + "\n"
                    + "Price: " + price + "\n"
                    + "Quantity: " + quantity;

            // Show popup dialog
            new AlertDialog.Builder(ProductAddActivity.this)
                    .setTitle("Confirm Product Details")
                    .setMessage(message)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setPositiveButton("Save", (dialog, which) -> {
                        Toast.makeText(ProductAddActivity.this, "Product Saved!", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        btnSave.setOnClickListener(v -> {
            saveProduct();
        });
    }

    private void saveProduct(){
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String priceStr = edtPrice.getText().toString().trim();
        String qtyStr = edtQuantity.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || priceStr.isEmpty() || qtyStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double price = Double.parseDouble(priceStr);
        int qty = Integer.parseInt(qtyStr);

        if (product == null) {
            product = new Product(0,qty,price,email,name);

            long id = productUtil.insert(product);

            if (id>0) {
                Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProductAddActivity.this, ProductListActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Product Insertion Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
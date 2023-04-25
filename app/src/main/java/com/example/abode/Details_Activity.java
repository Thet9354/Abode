package com.example.abode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abode.Model.ItemsDomain;

import java.text.DecimalFormat;

public class Details_Activity extends AppCompatActivity {

    private ImageView imgView_estate;
    private TextView txtView_estateName, txtView_estateAddress, txtView_estatePrice, txtView_bed, txtView_bath, txtView_wifi, txtView_desc;
    private androidx.appcompat.widget.AppCompatButton btn_buyNow;

    private ItemsDomain itemsDomain;
    DecimalFormat formatter = new DecimalFormat("###,###,###,##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initWidget();

        getTransferredIntentData();

        initUI();

        pageDirectories();
    }

    private void getTransferredIntentData() {

        itemsDomain = (ItemsDomain) getIntent().getSerializableExtra("object");

        txtView_estateName.setText(itemsDomain.getTitle());
        txtView_estateAddress.setText(itemsDomain.getAddress());
        txtView_bed.setText(itemsDomain.getBed() + " Bed");
        txtView_bath.setText(itemsDomain.getBath() + " Bath");
        txtView_desc.setText(itemsDomain.getDescription());
        txtView_estatePrice.setText("$" + formatter.format(itemsDomain.getPrice()));

        if (itemsDomain.isWifi())
            txtView_wifi.setText("Wifi");
        else
            txtView_wifi.setText("No-Wifi");

        int drawableResourcesId = getResources().getIdentifier(itemsDomain.getPic(), "drawable", getPackageName());

        Glide.with(this)
                .load(drawableResourcesId)
                .into(imgView_estate);
    }

    private void initUI() {


    }

    private void pageDirectories() {

    }

    private void initWidget() {

        //ImageView
        imgView_estate = findViewById(R.id.imgView_estate);

        //TextView
        txtView_estateName = findViewById(R.id.txtView_estateName);
        txtView_estateAddress = findViewById(R.id.txtView_estateAddress);
        txtView_estatePrice = findViewById(R.id.txtView_estatePrice);
        txtView_bed = findViewById(R.id.txtView_bed);
        txtView_bath = findViewById(R.id.txtView_bath);
        txtView_wifi = findViewById(R.id.txtView_wifi);
        txtView_desc = findViewById(R.id.txtView_desc);

        //Button
        btn_buyNow = findViewById(R.id.btn_buyNow);

    }
}
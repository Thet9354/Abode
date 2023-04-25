package com.example.abode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abode.Adapter.itemsAdapter;
import com.example.abode.Model.ItemsDomain;

import java.util.ArrayList;

public class MainPage_Activity extends AppCompatActivity {

    private androidx.recyclerview.widget.RecyclerView rv_popular, rv_new;
    private ImageView imgView_pfp, imgView_notification;
    private TextView txtView_accName, txtView_popularSeeAll, txtView_newSeeAll;
    private EditText editTxt_searchBar;
    private com.google.android.material.floatingactionbutton.FloatingActionButton fb_transfer;
    private LinearLayout ll_home, ll_profile, ll_favourite, ll_settings;
    private ArrayList<ItemsDomain> itemsDomainArrayList;
    private RecyclerView.Adapter adapterPopular, adapterNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

    }

    private void initUI() {

        initRecView();
    }

    private void initRecView() {

        itemsDomainArrayList = new ArrayList<>();

        itemsDomainArrayList.add(new ItemsDomain("House with a great view", "San Francisco, CA 94110", "This 2 bad /1 bath home boasts an enormous,\n" +
                " open-living plan, accented by striking \n" +
                " architectural features and high-end finishes.\n" +
                " Feel inspired by open sight lines that\n" +
                " embrace the outdoors, crowned by stunning\n" +
                " coffered celling. ", 2, 1, 841456, "pic1", true));

        itemsDomainArrayList.add(new ItemsDomain("House with a great view", "San Francisco, CA 94110", "This 2 bad /1 bath home boasts an enormous,\n" +
                " open-living plan, accented by striking \n" +
                " architectural features and high-end finishes.\n" +
                " Feel inspired by open sight lines that\n" +
                " embrace the outdoors, crowned by stunning\n" +
                " coffered celling. ", 3, 1, 654987, "pic2", false));

        itemsDomainArrayList.add(new ItemsDomain("House with a great view", "San Francisco, CA 94110", "This 2 bad /1 bath home boasts an enormous,\n" +
                " open-living plan, accented by striking \n" +
                " architectural features and high-end finishes.\n" +
                " Feel inspired by open sight lines that\n" +
                " embrace the outdoors, crowned by stunning\n" +
                " coffered celling. ", 3, 1, 841456, "pic1", true));

        rv_popular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_new.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterNew = new itemsAdapter(itemsDomainArrayList);
        adapterPopular = new itemsAdapter(itemsDomainArrayList);

        rv_new.setAdapter(adapterNew);
        rv_popular.setAdapter(adapterPopular);


    }

    private void initWidget() {

        //androidx.recyclerview.widget.RecyclerView
        rv_popular = findViewById(R.id.rv_popular);
        rv_new = findViewById(R.id.rv_new);

        //ImageView
        imgView_pfp = findViewById(R.id.imgView_pfp);
        imgView_notification = findViewById(R.id.imgView_notification);

        //TextView
        txtView_accName = findViewById(R.id.txtView_accName);
        txtView_popularSeeAll = findViewById(R.id.txtView_popularSeeAll);
        txtView_newSeeAll = findViewById(R.id.txtView_newSeeAll);

        //EditText
        editTxt_searchBar = findViewById(R.id.editTxt_searchBar);

        //FloatingButton
        fb_transfer = findViewById(R.id.fb_transfer);

        //LinearLayout
        ll_home = findViewById(R.id.ll_home);
        ll_profile = findViewById(R.id.ll_profile);
        ll_favourite = findViewById(R.id.ll_favourite);
        ll_settings = findViewById(R.id.ll_settings);

    }
}
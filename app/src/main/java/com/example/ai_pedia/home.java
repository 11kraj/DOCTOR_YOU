package com.example.ai_pedia;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<CardViewItem> dataList;
    private EditText searchEditText;
    Button cat,logoutBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.your_color));
        }
        setContentView(R.layout.activity_home);
        cat = findViewById(R.id.btn2);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(getApplicationContext(),category.class);
                startActivity(i1);
            }
        });
        auth = FirebaseAuth.getInstance();

        cat = findViewById(R.id.btn2);
        logoutBtn = findViewById(R.id.logoutBtn);

        // Handle click event for the logout button
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out the user from Firebase
                auth.signOut();

                // Redirect to the signin activity
                Intent intent = new Intent(getApplicationContext(), signin.class);
                startActivity(intent);
                finish();
            }
        });
        FirebaseUser user = auth.getCurrentUser();
        if (user == null) {
            // If the user is not signed in, redirect to the signin activity
            Intent intent = new Intent(getApplicationContext(), signin.class);
            startActivity(intent);
            finish();
        }

        recyclerView = findViewById(R.id.recyclerView);
        searchEditText = findViewById(R.id.searchEditText);

        // Create a list of CardViewItem objects with image, title, description, and activity class
        dataList = new ArrayList<>();
        dataList.add(new CardViewItem(R.drawable.crocin, "Crocin", "fever", card1.class));
        dataList.add(new CardViewItem(R.drawable.dolo, "Dolo", "fever", card2.class));
        dataList.add(new CardViewItem(R.drawable.calpol, "Calpol", "fever", card3.class));
        dataList.add(new CardViewItem(R.drawable.saridon, "Saridon", "fever", card4.class));
        dataList.add(new CardViewItem(R.drawable.benadryl, "Benadryl Syrup", "cough", card5.class));
        dataList.add(new CardViewItem(R.drawable.ascoril, "Ascoril", "cough", card6.class));
        dataList.add(new CardViewItem(R.drawable.cheston, "Cheston cold", "cough", card7.class));
        dataList.add(new CardViewItem(R.drawable.honitus, "Honitus", "cough", card8.class));
        dataList.add(new CardViewItem(R.drawable.coldact, "Coldact", "cold", card9.class));
        dataList.add(new CardViewItem(R.drawable.sinarest, "Sinarest", "cold", card10.class));
        dataList.add(new CardViewItem(R.drawable.cofsils, "Cofsils", "cold", card11.class));
        dataList.add(new CardViewItem(R.drawable.wikoryl, "Wikoryl", "cold", card12.class));
        dataList.add(new CardViewItem(R.drawable.digene, "Digene", "stomach ache pain", card13.class));
        dataList.add(new CardViewItem(R.drawable.gelusil, "Gelusil", "stomach ache pain", card14.class));
        dataList.add(new CardViewItem(R.drawable.eno, "Eno", "stomach ache pain", card15.class));
        dataList.add(new CardViewItem(R.drawable.pudinahara, "Pudin Hara", "stomach ache pain", card16.class));
        dataList.add(new CardViewItem(R.drawable.becadeexamine, "Becadexamin", "Malnutrition", card17.class));
        dataList.add(new CardViewItem(R.drawable.riconia, "Riconia", "Malnutrition", card18.class));
        dataList.add(new CardViewItem(R.drawable.livogeen, "Livogen", "Malnutrition", card19.class));
        dataList.add(new CardViewItem(R.drawable.zincovit, "Zincovit", "Malnutrition", card20.class));
        dataList.add(new CardViewItem(R.drawable.meftalspas, "Meftal Spas", "Period Cramps ", card21.class));
        dataList.add(new CardViewItem(R.drawable.regestrone, "Regestrone", "Period Cramps", card22.class));
        dataList.add(new CardViewItem(R.drawable.mensta, "Mensta", "Period Cramps", card23.class));
        dataList.add(new CardViewItem(R.drawable.pause, "Pause", "Period Cramps", card24.class));
        dataList.add(new CardViewItem(R.drawable.loperamide, "Loperamide", "Diarrhea", card25.class));
        dataList.add(new CardViewItem(R.drawable.enteroo, "Enterogermia", "Diarrhea", card26.class));
        dataList.add(new CardViewItem(R.drawable.norflox, "Norflox TZ", "Diarrhea", card27.class));
        dataList.add(new CardViewItem(R.drawable.electral, "Electral", "Diarrhea", card28.class));

        // Add more items as needed

        adapter = new RecyclerViewAdapter(dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Add a text change listener to the searchEditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Call a method to filter the data based on the search query
                filterData(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void filterData(String query) {
        List<CardViewItem> filteredList = new ArrayList<>();
        for (CardViewItem item : dataList) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.setData(filteredList);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private List<CardViewItem> dataList;

        public RecyclerViewAdapter(List<CardViewItem> dataList) {
            this.dataList = dataList;
        }

        public void setData(List<CardViewItem> dataList) {
            this.dataList = dataList;
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final CardViewItem item = dataList.get(position);
            holder.imageView.setImageResource(item.getImageResource());
            holder.titleTextView.setText(item.getTitle());
            holder.descriptionTextView.setText(item.getDescription());

            // Set click listener for the card view
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Launch the respective activity based on the card clicked
                    Intent intent = new Intent(home.this, item.getActivityClass());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            CardView cardView;
            ImageView imageView;
            TextView titleTextView;
            TextView descriptionTextView;

            ViewHolder(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.card_view);
                imageView = itemView.findViewById(R.id.imageView);
                titleTextView = itemView.findViewById(R.id.titleTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            }
        }
    }
}
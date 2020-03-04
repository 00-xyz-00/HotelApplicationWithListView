package com.bb.hotelapplicationwithlistview.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.bb.hotelapplicationwithlistview.R;
import com.bb.hotelapplicationwithlistview.adapter.NameAdapter;
import com.bb.hotelapplicationwithlistview.model.Name;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String GUEST_COUNT_KEY = "gust.count.key";
    private SharedPreferences sharedPreferences;
    private NameAdapter nameAdapter;

    private EditText nameEditText;
    private ListView namesListView;
    private Button confirmButton;

    private int guestCount = 0;
    private String guestKeyPrefix = "GUEST_";

    private List<String> guests = new ArrayList();
    private List<Name> names = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("com.bb.hotelapplicationwithlistview", Context.MODE_PRIVATE);

        nameEditText = findViewById(R.id.edit_name);
        namesListView = findViewById(R.id.names_list_view);
        confirmButton = findViewById(R.id.confirm_button);
        guestCount = sharedPreferences.getInt(GUEST_COUNT_KEY, 0);

         confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String guestName = nameEditText.getText().toString().trim();
                guestCount++;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(guestKeyPrefix + guestCount, guestName);
                editor.putInt(GUEST_COUNT_KEY, guestCount);
                editor.apply();
                readGuests();
                nameEditText.setText("");
                readGuests();
            }
        });
    }
    
    private void readGuests(){
        guestCount = sharedPreferences.getInt(GUEST_COUNT_KEY, 0);
        guests.clear();
        for (int i = 0; i < guestCount; i++) {
            String name = sharedPreferences.getString(guestKeyPrefix + (i + 1), "unknown");
            guests.add(name);
            names.add(new Name("Mr", name));
            
        }
        updateNames();
    }

    private void updateNames() {
        nameAdapter = new NameAdapter(names);
        namesListView.setAdapter(nameAdapter);
    }
    
    @Override
    protected void onStop(){
        super.onStop();
    }
}

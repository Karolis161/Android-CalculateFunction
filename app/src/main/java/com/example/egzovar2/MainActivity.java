package com.example.egzovar2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.egzovar2.menu.About;
import com.example.egzovar2.menu.Help;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        registerForContextMenu(button);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Tieses funkcijos");
        arrayList.add("Polinomai");
        arrayList.add("Trigonometrines funkcijos");
        arrayList.add("Hiperbolines funkcijos");
        arrayList.add("Laipsnine funkcija");
        arrayList.add("Logaritmines funkcijos");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getApplicationContext(), Functions.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Kontekstinis meniu");
        menu.add(0, v.getId(), 0, "Apie programa");
        menu.add(0, v.getId(), 0, "Kaip naudotis programa");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Apie programa"){
            Intent intent = new Intent(getApplicationContext(), About.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(), Help.class);
            startActivity(intent);
        }
        return true;
    }
}
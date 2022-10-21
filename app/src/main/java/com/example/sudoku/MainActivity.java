package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TableLayout tableLayout;
    private Modelo modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelo = new Modelo();

        tableLayout = findViewById(R.id.tableLayout);
        crearTabla(modelo);
    }

    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight = 1;
        return params;
    }

    private void crearTabla(Modelo modelo){
        for (int i = 0; i < modelo.sudoku.length; i++) {
            TableRow tr = new TableRow(this.getApplicationContext());
            for (int j = 0; j < modelo.sudoku[i].length; j++) {
                Spinner spinner = new Spinner(this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.numeros, android.R.layout.simple_spinner_item);
                spinner.setBackground(null);
                spinner.setAdapter(adapter);
                spinner.setPadding(5, 5, 5, 5);
                spinner.setTag(R.id.fila,i);
                spinner.setTag(R.id.col,j);
                spinner.setOnItemSelectedListener(this);
                tr.addView(spinner);
            }
            tableLayout.addView(tr);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
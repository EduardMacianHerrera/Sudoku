package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
    private Spinner[][] spinners = new Spinner[9][9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelo = new Modelo();

        tableLayout = findViewById(R.id.tableLayout);
        crearTabla(modelo);
        modelo.creaPartida();
        refrescaGUI();
//        modelo.setVal(0,0,3);
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
                spinners[i][j] = spinner;
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, Modelo.opciones);
                spinner.setBackground(null);
                spinner.setAdapter(adapter);
                spinner.setPadding(40, 30, 3, 3);
                spinner.setTag(R.id.fila,i);
                spinner.setTag(R.id.col,j);
                spinner.setOnItemSelectedListener(this);
                tr.addView(spinner);
            }
            tableLayout.addView(tr);
        }
    }

    public void refrescaGUI(){
        for (int i = 0; i < modelo.sudoku.length; i++) {
            for (int j = 0; j < modelo.sudoku[i].length; j++) {
                String valor = String.valueOf(modelo.sudoku[i][j]);
                for (int k = 0; k < Modelo.opciones.length; k++) {
                    if (Modelo.opciones[k].equals(valor)){
                        spinners[i][j].setSelection(k);
                    }
                }



            }
        }
    }
    
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //refrescaGUI();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
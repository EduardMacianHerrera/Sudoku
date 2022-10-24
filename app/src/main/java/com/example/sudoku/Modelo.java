package com.example.sudoku;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Modelo {

    public static int[][] sudoku = new int[9][9];
    public static CharSequence[] opciones = {"1","2","3","4","5","6","7","8","9"};

    public int getVal(int fila, int col){
        int val = sudoku[fila][col];
        return val;
    }

    private void iniciarSudoku(){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                sudoku[i][j] = 0;
            }
        }
    }

    public void creaPartida(){
        Random random = new Random();
        iniciarSudoku();

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                int valor = (int) Math.random()*10 + 1;
                while (setVal(i,j,valor) == -1) {
                    valor = random.nextInt(10);
                }
            }
        }
    }

    public int setVal(int fila, int col, int val){ // ACABAR
        int compFila = comprovaFila(fila);
        int compCol = comprovaCol(col);
        int compQuad = comprovaQuad(fila,col);

        //Log.i("BASURA", "setVal: "+compFila+" "+compCol+" "+compQuad);

        if (compFila == 1 && compCol == 1 && compQuad == 1){
            sudoku[fila][col] = val;
            return 1;
        } else {
            return -1;
        }
    }

    public int comprovaFila(int fila){ // Itera la fila añadiendo los numeros y comprobando si no existen ya
        ArrayList<Integer> valorsFila = new ArrayList<Integer>();
        for (int i = 0; i < sudoku[fila].length; i++) {
            if (sudoku[fila][i] != 0){
                if (valorsFila.contains(sudoku[fila][i])){
                    return -1;
                } else {
                    valorsFila.add(sudoku[fila][i]);
                }
            }
        }
        return 1;
    }

    public int comprovaCol(int col){
        ArrayList<Integer> valorCol = new ArrayList<Integer>();
        for (int i = 0; i < sudoku.length; i++){
            if (sudoku[i][col] != 0){
                if (valorCol.contains(sudoku[i][col])){
                    return -1;
                } else {
                    valorCol.add(sudoku[i][col]);
                }
            }
        }
        return 1;
    }

    public int comprovaQuad(int fila, int col){
        int x = 0, y = 0;
        if (fila < 3 && col < 3){
            x = 0;
            y = 0;
        } else if (fila < 3 && col < 6){
            x = 3;
            y = 0;
        } else if (fila < 3 && col < 9){
            x = 6;
            y = 0;
        } else if (fila < 6 && col < 3){
            x = 0;
            y = 3;
        } else if (fila < 6 && col < 6){
            x = 3;
            y = 3;
        } else if (fila < 6 && col < 9){
            x = 6;
            y = 3;
        } else if (fila < 9 && col < 3){
            x = 0;
            y = 6;
        } else if (fila < 9 && col < 6){
            x = 3;
            y = 6;
        } else {
            x = 6;
            y = 6;
        }

        ArrayList<Integer> valoresQuad = new ArrayList<Integer>();

        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (sudoku[i][j] != 0){
                    if (valoresQuad.contains(sudoku[i][j])){
                        return -1;
                    } else {
                        valoresQuad.add(sudoku[i][j]);
                    }
                }
            }
        }
        return 1;
    }

}
